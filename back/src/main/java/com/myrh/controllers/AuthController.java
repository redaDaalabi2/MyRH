package com.myrh.controllers;

import com.myrh.dto.AuthRequest;
import com.myrh.models.Company;
import com.myrh.services.AgentService;
import com.myrh.services.CompanyService;
import com.myrh.utils.Enum;
import com.myrh.utils.JwtUtils;
import com.myrh.utils.LoggedIn;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final AgentService agentService;
    private final CompanyService companyService;
    private final JwtUtils jwtUtils;

    @PostMapping("agent")
    public ResponseEntity<Object> agentAuth(
            @RequestBody AuthRequest request
            ){
        setAuthenticationManager(request.getLogin(), request.getPassword());
        final UserDetails user = agentService.findByEmail(request.getLogin());
        if(user != null){
            LoggedIn loggedIn = new LoggedIn();
            loggedIn.setAgent(agentService.getAgentByLogin(user.getUsername()));
            loggedIn.setCompany(null);
            loggedIn.setRole(Enum.role.AGENT.toString());
            loggedIn.setToken(jwtUtils.generateToken(user));
            return ResponseEntity.ok(loggedIn);
        }
        return ResponseEntity.status(400).body("Some error has occurred");
    }

    @PostMapping("company")
    public ResponseEntity<Object> companyAuth(
            @RequestBody AuthRequest request
    ){
        setAuthenticationManager(request.getLogin(), request.getPassword());
        final UserDetails user = companyService.findByEmail(request.getLogin());
        if(user != null){
            LoggedIn loggedIn = new LoggedIn();
            loggedIn.setAgent(null);
            loggedIn.setCompany(companyService.getCompanyByLogin(user.getUsername()));
            loggedIn.setRole(Enum.role.COMPANY.toString());
            loggedIn.setToken(jwtUtils.generateToken(user));
            return ResponseEntity.ok(loggedIn);
        }
        return ResponseEntity.status(400).body("Some error has occurred");
    }

    public void setAuthenticationManager(String email, String password){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );
    }

}
