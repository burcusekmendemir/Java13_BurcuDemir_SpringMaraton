package com.burcu.entity;


import com.burcu.utility.enums.Cinsiyet;
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
@Table(name = "tbl_hasta")
public class Hasta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String hastaAdi;
    private String adres;
    private String phone;
    private int yas;
    @Enumerated(EnumType.STRING)
    private Cinsiyet cinsiyet;

}
