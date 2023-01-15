package com.myrh.services;

import com.myrh.models.Profile;
import com.myrh.repositories.ProfileRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Repository
public class ProfileService {
    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public List<Profile> listAll(){
        return profileRepository.findAll();
    }

    public Profile getProfileById(Long id){
        Optional profile = profileRepository.findById(id);
        return profile.isPresent() ? (Profile) profile.get() : null;
    }

    public Profile save(Profile profile){
        return profileRepository.save(profile);
    }

}
