package com.example.password.valid;

import com.example.password.exception.PasswordValidException;

public interface PasswordValid {
    void validate(String input) throws PasswordValidException;
}
