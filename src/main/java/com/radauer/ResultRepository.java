package com.radauer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Andreas on 26.04.2017.
 */
public interface ResultRepository extends JpaRepository<Result, Long> {

    List<Result> findByEmail(String email);

}
