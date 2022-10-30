package com.example.password.service;

import com.example.password.exception.PasswordValidException;
import com.example.password.valid.PasswordValid;
import com.example.password.valid.ValidResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ValidService {
    @Autowired
    private List<PasswordValid> validList;

    public ValidResult validate(String password){
        ValidResult result =  new ValidResult();
        result.setValid(true);
        for(PasswordValid validator : validList){
            try {
                validator.validate(password);
            } catch (PasswordValidException e) {
               result.setValid(false);
               result.addValidErrorsMsg(e.getMessage());
            }
        }
        return result;
    }
}
