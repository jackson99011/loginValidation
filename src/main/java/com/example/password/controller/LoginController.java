package com.example.password.controller;

import com.example.password.service.ValidService;
import com.example.password.valid.ValidResult;
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
    private ValidService validService;


    @PostMapping("/passwordValid")
    public ResponseEntity<?> passwordValid(@RequestBody @Valid String password)
    {
        ValidResult result =  validService.validate(password);
        if(result.isValid()){
            return ResponseEntity.status(HttpStatus.OK)
                    .build();
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(result.getValidErrorsMsg());
        }
    }
}
