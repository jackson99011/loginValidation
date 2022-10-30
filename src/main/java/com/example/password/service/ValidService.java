package com.example.password.service;

import com.example.password.valid.PasswordValid;
import com.example.password.valid.PasswordValidResult;
import com.example.password.valid.ValidResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ValidService {
    @Autowired
    private List<PasswordValid> validators;

    public PasswordValidResult validate(String password){
        PasswordValidResult result =  new PasswordValidResult();
        result.setValid(true);
        for(PasswordValid validator : validators){
            ValidResult validResult = validator.validate(password);
            if (!validResult.isTrue()) {
                result.setValid(false);
                result.addValidErrorsMsg(validResult.getErrorMessage());
            }
        }
        return result;
    }
}
