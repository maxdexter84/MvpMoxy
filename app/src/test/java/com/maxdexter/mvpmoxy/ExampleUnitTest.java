package com.maxdexter.mvpmoxy;

import com.maxdexter.mvpmoxy.test.unit.Math;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ExampleUnitTest {
    private Math mMath;
    @Before
    public void before() {
         mMath = new Math();
    }
    @Test
    public void addition_isCorrect() {
        int a = 2;
        int b = 2;
        int res = mMath.addition(a, b);
        Assert.assertEquals(4, 2 + 2);
    }
    @Test
    public void addition_isIncorrect() {
        int a = 2;
        int b = 2;
        int res = mMath.addition(a, b);
        Assert.assertNotEquals(5, 2 + 2);
    }

}