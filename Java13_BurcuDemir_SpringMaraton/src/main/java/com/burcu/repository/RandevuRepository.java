package com.burcu.repository;

import com.burcu.entity.Randevu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RandevuRepository extends JpaRepository<Randevu,Long> {


    List<Randevu> findAllByDoktorIdAndTarihAndSaat(Long id, String tarih, String saat);

    List<Randevu> findAllByDoktorId(Long id);

}
