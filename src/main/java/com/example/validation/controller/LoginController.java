package com.example.validation.controller;

import com.example.validation.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;


    @PostMapping("/products")
    public ResponseEntity<?> loginValid(@RequestBody @Valid String input)
    {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
