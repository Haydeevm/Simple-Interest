package com.simple.interest.servicios.repository;


import com.simple.interest.servicios.domain.Interest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterestRepository extends JpaRepository<Interest, Long> {}
