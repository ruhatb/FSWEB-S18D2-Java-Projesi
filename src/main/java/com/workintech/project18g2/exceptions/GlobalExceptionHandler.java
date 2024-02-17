package com.workintech.project18g2.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler   //FruitException tipindeki özel hataları ele alıyor hatalar FruitErrorException nesnesine dönüştürülür
    public ResponseEntity<FruitErrorException> handleException(FruitException exception){
     FruitErrorException response = new FruitErrorException(exception.getMessage(),exception.getHttpStatus().value,System.currentTimeMillis());
     return new ResponseEntity<>(response,exception.getHttpStatus());
    }

    @ExceptionHandler  //özel bir hata tipyle eşleşmeyen tüm genel hataları ele alır.
    public ResponseEntity<FruitErrorException> handleException(Exception exception){
       FruitErrorException response= new FruitErrorException(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), System.currentTimeMillis());
    return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //responseEntity http yanıtlarını temsil eder. HTTP yanıtı olusturmak ve bunu yönetmek icin kullanılır. dönülen yanıt içeriği FruitErrorException tipindedir ve Spring Framework'ün ResponseEntity sınıfı aracılığıyla temsil edilir.
}

