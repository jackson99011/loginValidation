package com.example.password.valid;

import com.example.password.exception.PasswordValidException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
//驗證是否為小寫字母和數字
//a mixture of lowercase letters and numerical digits
public class ValidLowerAndDigits implements PasswordValid {

    @Override
    public void validate(String input) throws PasswordValidException {
        Pattern pattern = Pattern.compile("[a-z\\d]*");
        Matcher matcher = pattern.matcher(input);
        if(!matcher.matches())
            throw new PasswordValidException("Password must is a mixture of lowercase" +
                    "letters and numerical digits");
    }
}
