package com.workintech.project18g2.exceptions;


import lombok.Data;

@Data
public class FruitErrorException {
    private String message;
    private int status;
    private long timestap;

    public FruitErrorException(String message, int value, long l) {
    }
}
