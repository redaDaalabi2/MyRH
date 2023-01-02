package com.MyRH.backend.utils;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;


@Configuration
public class Sms {
    @Autowired
    private Environment env;
    @Value("${ACCOUNT_SID}")
    private String accountSid;
    @Value("${AUTH_TOKEN}")
    private String authToken;
    @Value("${TWILIO_NUMBER}")
    private String twilioNumber;

    public Boolean sendSms(String to, String body) {
        // Set up account SID and auth token
        System.out.println("accountSid = " + "ACccc0e04e71f343266762eeb230b2b65f");
        System.out.println("en" + "+19295564548");
        Twilio.init("ACccc0e04e71f343266762eeb230b2b65f", "a2c700c07a386bcb43006dde22965545");
        Message message = Message.creator(new PhoneNumber(to), new PhoneNumber("+19295564548"), body).create();
        return message.getErrorMessage() == null;
    }
}
