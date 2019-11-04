package com.wzt.springboot.springboot.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResourseNotFoundException extends RuntimeException {
    private String message;

    public ResourseNotFoundException(String message){
        super(message);
        this.message = message;
    }
}
