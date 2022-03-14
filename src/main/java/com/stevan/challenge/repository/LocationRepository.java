package com.stevan.challenge.repository;

import com.stevan.challenge.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, String> {

}
