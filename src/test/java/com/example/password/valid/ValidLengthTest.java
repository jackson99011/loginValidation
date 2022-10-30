package com.example.password.valid;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ValidLengthTest {

    @Test
    public void testValid(){
        ValidLength validLength = new ValidLength();
        ValidResult validResult = validLength.validate("1a2b3c");
        Assert.assertTrue(validResult.isTrue());
    }

    @Test
    public void chars_5(){
        ValidLength validLength = new ValidLength();
        ValidResult validResult = validLength.validate("1a2b3");
        Assert.assertTrue(validResult.isTrue());
    }

    @Test
    public void chars_less5(){
        ValidLength validLength = new ValidLength();
        ValidResult validResult = validLength.validate("1a2b");
        Assert.assertFalse(validResult.isTrue());
    }

    @Test
    public void chars_12(){
        ValidLength validLength = new ValidLength();
        ValidResult validResult = validLength.validate("1234567890ab");
        Assert.assertTrue(validResult.isTrue());
    }

    @Test
    public void chars_bigger12(){
        ValidLength validLength = new ValidLength();
        ValidResult validResult = validLength.validate("1234567890abcd");
        Assert.assertFalse(validResult.isTrue());
    }
}
