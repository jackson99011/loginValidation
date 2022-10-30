package com.example.password.valid;

public class ValidResult {
    private boolean isTrue;
    private String errorMessage;

    public boolean isTrue() {
        return isTrue;
    }

    public void setTrue(boolean aTrue) {
        this.isTrue = aTrue;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
