package com.burcu.exception;

import lombok.Getter;

@Getter
public class DoktorRandevuAppException extends RuntimeException {

    private final ErrorType errorType;

    public DoktorRandevuAppException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public DoktorRandevuAppException(ErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }


}
