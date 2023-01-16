package com.myrh.utils;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Sms {
    public Boolean sendSms(String to, String body) {
        // Set up account SID and auth token
        System.out.println("accountSid = " + "ACccc0e04e71f343266762eeb230b2b65f");
        System.out.println("+19295564548");
        Twilio.init("ACccc0e04e71f343266762eeb230b2b65f", "bf3a44b6c2536774c63bcd4d556478e4");
        Message message = Message.creator(new PhoneNumber(to), new PhoneNumber("+19295564548"), body).create();
        return message.getErrorMessage() == null;
    }
}
