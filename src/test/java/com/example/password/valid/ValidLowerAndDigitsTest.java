package com.example.password.valid;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ValidLowerAndDigitsTest {
    @Test
    public void testValid(){
        ValidLowerAndDigits valid = new ValidLowerAndDigits();
        ValidResult validResult = valid.validate("1a2b3c");
        Assert.assertTrue(validResult.isTrue());
    }

    @Test
    public void UpperLetterValid(){
        ValidLowerAndDigits valid = new ValidLowerAndDigits();
        ValidResult validResult = valid.validate("ABCDef");
        Assert.assertFalse(validResult.isTrue());
    }

    @Test
    public void specialChar(){
        ValidLowerAndDigits valid = new ValidLowerAndDigits();
        ValidResult validResult = valid.validate(".!@#$$%aaa");
        Assert.assertFalse(validResult.isTrue());
    }
}
