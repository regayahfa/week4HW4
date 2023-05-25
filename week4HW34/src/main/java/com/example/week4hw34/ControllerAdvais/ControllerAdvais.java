package com.example.week4hw34.ControllerAdvais;

import com.example.week4hw34.ApiException.ApiExcption;
import com.example.week4hw34.Apirespons.ApiRespons;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvais {
    @ExceptionHandler(value = ApiExcption.class)
    public ResponseEntity<ApiRespons>ApiExcption(ApiExcption e){
        String messege=e.getMessage();
    return ResponseEntity.status(400).body(new ApiRespons(messege));
    }
}
