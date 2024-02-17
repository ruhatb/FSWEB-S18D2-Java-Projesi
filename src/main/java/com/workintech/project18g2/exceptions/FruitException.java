package com.workintech.project18g2.exceptions;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@AllArgsConstructor
@Data
public class FruitException extends RuntimeException {
    private HttpStatus httpStatus;

    public FruitException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus=httpStatus;
    }

    public HttpStatusCode getHttpStatus() {
        return httpStatus;
    }
}
