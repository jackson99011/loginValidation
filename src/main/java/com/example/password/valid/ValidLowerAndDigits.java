package com.example.password.valid;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
//驗證是否為小寫字母和數字
//a mixture of lowercase letters and numerical digits
public class ValidLowerAndDigits implements PasswordValid {

    @Override
    public ValidResult validate(String input) {
        ValidResult validResult = new ValidResult();
        Pattern pattern = Pattern.compile("[a-z\\d]*");
        Matcher matcher = pattern.matcher(input);
        if(!matcher.matches()) {
            validResult.setTrue(false);
            validResult.setErrorMessage("Password must is a mixture of lowercase" +
                                        "letters and numerical digits");
        }
        else
            validResult.setTrue(true);
        return validResult;
    }
}
