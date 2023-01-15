package com.myrh.services;

import com.myrh.utils.Enum;
import com.myrh.models.Agent;
import com.myrh.repositories.AgentRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Repository
public class AgentService {

    private final AgentRepository agentRepository;

    public AgentService(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    public Agent save(Agent agent){
        return agentRepository.save(agent);
    }

    public List<Agent> listAll(){
        return agentRepository.findAll();
    }

    public UserDetails findByEmail(String login){
        Agent user = agentRepository.findAll()
                .stream()
                .filter(u -> (u.getEmail()).equals(login))
                .findFirst()
                .orElse(null);
        return user != null ? new User(
                user.getEmail(),
                user.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority(Enum.role.AGENT.toString()))) : null ;
    }

    public Agent getAgentByLogin(String login){
        return agentRepository.findByEmail(login);
    }
}
