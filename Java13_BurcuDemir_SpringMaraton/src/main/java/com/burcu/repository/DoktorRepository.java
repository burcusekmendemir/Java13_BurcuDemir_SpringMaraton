package com.burcu.repository;

import com.burcu.entity.Doktor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DoktorRepository extends JpaRepository<Doktor,Long> {

    Optional<Doktor> findByDoktorAdi(String ad);

    List<Doktor> findAllByOrderByDoktorStatusDesc();
}
