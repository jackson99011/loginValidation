package com.example.password.valid;

import com.example.password.exception.PasswordValidException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
//Must not contain any sequence of characters immediately followed by the same sequence.
public class ValidNotRepeatSequence implements PasswordValid {
    @Override
    public void validate(String input) throws PasswordValidException {
        Pattern pattern = Pattern.compile("(?!(.+?)\\1).*");
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches())
            throw new PasswordValidException("Must not contain any sequence of characters immediately " +
                    "followed by the same sequence.");
    }
}
