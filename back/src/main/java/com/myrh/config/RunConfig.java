package com.myrh.config;

import com.myrh.models.Agent;
import com.myrh.models.Profile;
import com.myrh.repositories.ProfileRepository;
import com.myrh.services.AgentService;
import com.myrh.services.ProfileService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RunConfig {

//    @Bean
    CommandLineRunner commandLineRunner(AgentService agService){
        return args -> {
            Agent agent = new Agent("agent@my-rh.com", "$2y$10$RVIo5RnOOfuYLoMkMK2js.MouZv.vywNuviWFofY4LMuLpQNfB/Ei");
            agService.save(agent);
        };
    }

//    @Bean
    CommandLineRunner commandLineRunProfiles(ProfileRepository profileRepository){
        return args -> {
            Profile p1 = new Profile("Web Security");
            Profile p2 = new Profile("Networking");
            Profile p3 = new Profile("PHP Back-end developer");
            Profile p4 = new Profile("Java full stack developer");
            Profile p5 = new Profile("front-end developer");
            profileRepository.saveAll(List.of(p1,p2,p3,p4,p5));
        };
    }

}
