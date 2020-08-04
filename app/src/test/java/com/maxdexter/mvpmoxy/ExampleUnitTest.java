package com.maxdexter.mvpmoxy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Before
    @Test
    public void addition_isCorrect() {
        int res =
        Assert.assertEquals(4, 2 + 2);
    }
    @Test
    public void addition_isIncorrect() {
        Assert.assertNotEquals(4, 2 + 3);
    }

}