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


    @PostMapping("/loginValid")
    public ResponseEntity<?> loginValid(@RequestBody @Valid String input)
    {
        if (input.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        else
            return ResponseEntity.status(HttpStatus.OK).build();
    }
}
