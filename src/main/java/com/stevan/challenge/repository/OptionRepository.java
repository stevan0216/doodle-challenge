package com.stevan.challenge.repository;

import com.stevan.challenge.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OptionRepository extends JpaRepository<Option, Integer> {
    @Query("select o from Option o where o.idOption=:idOption")
    Option getOption(@Param("idOption") int idOption);

}
