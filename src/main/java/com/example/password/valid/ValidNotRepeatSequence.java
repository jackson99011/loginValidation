package com.example.password.valid;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
//Must not contain any sequence of characters immediately followed by the same sequence.
public class ValidNotRepeatSequence implements PasswordValid {
    @Override
    public ValidResult validate(String input) {
        ValidResult validResult = new ValidResult();
        Pattern pattern = Pattern.compile("(?!(.+?)\\1).*");
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            validResult.setTrue(false);
            validResult.setErrorMessage("Must not contain any sequence of characters immediately " +
                    "followed by the same sequence.");
        }
        else
            validResult.setTrue(true);
        return validResult;
    }
}
