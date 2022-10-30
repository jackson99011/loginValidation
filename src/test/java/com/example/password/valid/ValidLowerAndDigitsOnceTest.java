package com.example.password.valid;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ValidLowerAndDigitsOnceTest {
    @Test
    public void testValid(){
        ValidLowerAndDigitsOnce valid = new ValidLowerAndDigitsOnce();
        ValidResult validResult = valid.validate("1a");
        Assert.assertTrue(validResult.isTrue());
    }

    @Test
    public void allLetterValid(){
        ValidLowerAndDigitsOnce valid = new ValidLowerAndDigitsOnce();
        ValidResult validResult = valid.validate("ABCDef");
        Assert.assertFalse(validResult.isTrue());
    }

    @Test
    public void allDigitsValid(){
        ValidLowerAndDigitsOnce valid = new ValidLowerAndDigitsOnce();
        ValidResult validResult = valid.validate("987654");
        Assert.assertFalse(validResult.isTrue());
    }
}
