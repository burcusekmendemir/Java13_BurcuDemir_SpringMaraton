package com.burcu.entity;

import com.burcu.utility.enums.RandevuStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_randevu")
public class Randevu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long doktorId;
    private String hastaAdi;
    private String tarih;
    private String saat;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private RandevuStatus status=RandevuStatus.PASSIVE;
}
