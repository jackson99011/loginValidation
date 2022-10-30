package com.example.password.valid;

import com.example.password.exception.PasswordValidException;
//Password must be between 5 and 12 characters in length.
public class ValidLength implements PasswordValid{
    @Override
    public void validate(String input) throws PasswordValidException {
        int length = input.length();
        if (length < 5 || length > 12 )
            throw new PasswordValidException("Password must be between 5 and 12 characters in length.");
    }
}
