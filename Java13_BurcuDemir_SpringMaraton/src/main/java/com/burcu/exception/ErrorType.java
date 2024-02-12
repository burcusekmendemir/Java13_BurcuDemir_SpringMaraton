package com.burcu.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ErrorType {

    INTERNAL_SERVER_ERROR(5000, "Sunucu Hatası", HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST_ERROR(4100,"Parametre Hatası", HttpStatus.BAD_REQUEST),
    DOCTOR_NOT_FOUND(4111, "Böyle bir doktor bulunamadı.", HttpStatus.BAD_REQUEST),
    DOCTOR_ALREADY_EXISTS(4112, "Bu doktor sistemde zaten kayıtlıdır.", HttpStatus.BAD_REQUEST),
    DOCTOR_IS_FULL(4113, "Bu doktor şuan sistemde dolu gözüküyor.",HttpStatus.BAD_REQUEST),
    RANDEVU_IS_FULL(4114,"Seçmiş olduğunuz randevu doludur.", HttpStatus.BAD_REQUEST);


    int code;
    String message;
    HttpStatus httpStatus;


}
