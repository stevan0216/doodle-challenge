package com.stevan.challenge.repository;

import com.stevan.challenge.entity.Preference;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PreferenceRepository extends JpaRepository<Preference, Integer> {
    List<Preference> findByPollOptionId(int pollOptionId);
}
