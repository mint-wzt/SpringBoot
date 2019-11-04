package com.wzt.springboot.springboot.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private String errorTypeName;

    public ErrorResponse(Exception e) {
        this(e.getClass().getName(), e.getMessage());
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "errorTypeName='" + errorTypeName + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

}
