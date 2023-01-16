package com.myrh.controllers;

import com.myrh.dto.RegisterRequest;
import com.myrh.models.Company;
import com.myrh.services.CompanyService;
import com.myrh.utils.Mail;
import com.myrh.utils.RandomCode;
import com.myrh.utils.SendMail;
import com.myrh.utils.Sms;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;

@RestController
public class CompanyController {

    private Company company;
    private int codeVer;
    private final SendMail sendMail;
    private final CompanyService companyService;
    private LocalTime setTime;

    public CompanyController(SendMail sendMail, CompanyService companyService) {
        this.sendMail = sendMail;
        this.companyService = companyService;
    }

    @PostMapping("register")
    public ResponseEntity<Object> registration(
            @RequestBody RegisterRequest req
    ){
        company = new Company(req.getName(), req.getLogin(), BCrypt.hashpw(req.getPassword(), BCrypt.gensalt(10)),
                req.getEmail(), req.getPhone(), req.getAddress(), req.getImageUrl());
        codeVer = RandomCode.generate();
        System.out.println(codeVer);
        setTime = LocalTime.now();
        Sms sms = new Sms();
        sms.sendSms(req.getPhone(), "Your verification code is: " + codeVer);
        Mail mail = new Mail();
        mail.sendMail(req.getEmail(), "Your verification code is: " + codeVer);
        return ResponseEntity.ok(company);
    }

    @PostMapping("/code-verification")
    public ResponseEntity<String> verRegistration(
            @RequestParam int codeParamVer){
        if((codeParamVer == codeVer) && (company != null)){
            if(isCodeValid()){
                if(companyService.save(company) != null) {
                    company = null;
                    return ResponseEntity.ok("Success registration");
                }
            }else{
                ResponseEntity.status(400).body("The code has expired");
            }
        }
        return ResponseEntity.status(400).body("Failed creation company");
    }

    @GetMapping("/resend-code")
    public ResponseEntity<String> resendVerCode(){
        codeVer = RandomCode.generate();
        sendMail.sendVerificationCode(company.getEmail(), "Code verification", "Code: "+codeVer+" .");
        setTime = LocalTime.now();
        return ResponseEntity.ok("The code has been sent to you, check your email.");
    }

    public boolean isCodeValid(){
        LocalTime now = LocalTime.now();
        return now.isBefore(setTime.plusMinutes(3));
    }

    @GetMapping("/company/all")
    public ResponseEntity<Object> all(){
        return ResponseEntity.ok(companyService.listAll());
    }
}
