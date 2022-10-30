package com.example.password.valid;

//Password must be between 5 and 12 characters in length.
public class ValidLength implements PasswordValid{
    @Override
    public ValidResult validate(String input) {
        ValidResult validResult = new ValidResult();
        int length = input.length();
        if (length < 5 || length > 12 ) {
            validResult.setTrue(false);
            validResult.setErrorMessage("Password must be between 5 and 12 characters in length.");
        }
        else
            validResult.setTrue(true);
        return validResult;
    }
}
