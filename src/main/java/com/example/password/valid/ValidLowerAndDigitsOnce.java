package com.example.password.valid;

//驗證小寫字母和數字至少出現一次
//lowercase letters and numerical digits  with at least one of each.
public class ValidLowerAndDigitsOnce implements PasswordValid {

    @Override
    public ValidResult validate(String input) {
        boolean isDigit = false;
        boolean isLetter = false;
        ValidResult validResult = new ValidResult();

        for(int i = 0 ; i < input.length(); i++) {
            if(Character.isDigit(input.charAt(i))) {
                isDigit = true;
            }
            if(Character.isLetter(input.charAt(i)) && Character.isLowerCase(input.charAt(i))) {
                isLetter = true;
            }
            if(isDigit && isLetter)
            {
                validResult.setTrue(true);
                return validResult;
            }
        }
        validResult.setTrue(false);
        validResult.setErrorMessage("lowercase letters and numerical digits  with at least one of each.");
        return validResult;
    }
}
