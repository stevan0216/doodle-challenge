package com.stevan.challenge.repository;

import com.stevan.challenge.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
}
