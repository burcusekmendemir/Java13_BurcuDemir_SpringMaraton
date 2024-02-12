package com.burcu.entity;


import com.burcu.utility.enums.DoktorStatus;
import com.burcu.utility.enums.Unvan;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_doktor")
public class Doktor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long bransId;
    private String doktorAdi;
    @Enumerated(EnumType.STRING)
    private Unvan unvan;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private DoktorStatus doktorStatus=DoktorStatus.BOS;

}
