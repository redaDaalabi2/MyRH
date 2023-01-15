package com.myrh.repositories;

import com.myrh.models.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, Long> {
    Agent findByEmail(String email);
}
