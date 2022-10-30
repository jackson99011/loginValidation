package com.example.password.valid;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ValidNotRepeatSequenceTest {
    @Test
    public void testValid() {
        ValidNotRepeatSequence valid = new ValidNotRepeatSequence();
        ValidResult validResult = valid.validate("1a2b3c");
        Assert.assertTrue(validResult.isTrue());
    }

    @Test
    public void hasRepeatValid() {
        ValidNotRepeatSequence valid = new ValidNotRepeatSequence();
        ValidResult validResult = valid.validate("1a1a");
        Assert.assertFalse(validResult.isTrue());
    }

    @Test
    public void noRepeatValid() {
        ValidNotRepeatSequence valid = new ValidNotRepeatSequence();
        ValidResult validResult = valid.validate("1acccc1a");
        Assert.assertTrue(validResult.isTrue());
    }
}
