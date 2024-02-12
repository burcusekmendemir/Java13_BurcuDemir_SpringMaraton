package com.burcu.repository;

import com.burcu.entity.Brans;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BransRepository extends JpaRepository<Brans,Long> {
    Optional<Brans> findByBransName(String bransName);
}
