package com.myrh.utils;

import com.myrh.models.Agent;
import com.myrh.models.Company;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoggedIn {

    private Company company;
    private Agent agent;
    private String token;
    private String role;

}
