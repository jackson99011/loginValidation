package com.example.password.valid;

import com.example.password.exception.PasswordValidException;
//驗證小寫字母和數字至少出現一次
//lowercase letters and numerical digits  with at least one of each.
public class ValidLowerAndDigitsOnce implements PasswordValid {

    @Override
    public void validate(String input) throws PasswordValidException {
        boolean isDigit = false;
        boolean isLetter = false;

        for(int i = 0 ; i < input.length(); i++) {
            if(Character.isDigit(input.charAt(i))) {
                isDigit = true;
            }
            if(Character.isLetter(input.charAt(i)) && Character.isLowerCase(input.charAt(i))) {
                isLetter = true;
            }
            if(isDigit && isLetter)
                return;
        }
        throw new PasswordValidException("lowercase letters and numerical digits  with at least one of each.");
    }
}
