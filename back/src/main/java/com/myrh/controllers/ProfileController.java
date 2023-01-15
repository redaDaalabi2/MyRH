package com.myrh.controllers;

import com.myrh.models.Profile;
import com.myrh.services.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("profiles")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping()
    public ResponseEntity<Object> allProfiles(){
        return ResponseEntity.ok(profileService.listAll());
    }

}
