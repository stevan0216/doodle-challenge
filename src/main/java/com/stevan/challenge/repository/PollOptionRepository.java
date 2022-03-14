package com.stevan.challenge.repository;

import com.stevan.challenge.entity.PollOption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PollOptionRepository extends JpaRepository<PollOption, Integer> {
    List<PollOption> findByPollId(String pollId);
}
