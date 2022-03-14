package com.stevan.challenge.repository;

import com.stevan.challenge.entity.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PollRepository extends JpaRepository<Poll, String> {
    List<Poll> findByInitiator(int initiator);

    @Query("select p from Poll p where p.title like %:title%")
    List<Poll> findByTitle(String title);

    @Query("select p from Poll p where p.initiated > :date")
    List<Poll> findPollsAfterDate(Long date);
}
