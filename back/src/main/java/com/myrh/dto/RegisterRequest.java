package com.myrh.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class RegisterRequest {

    private String name;
    private String login;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String imageUrl;

}
