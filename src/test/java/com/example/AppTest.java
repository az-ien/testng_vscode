package com.example;

import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
         int a = 6;
        int b = 3;
        int result = a + b;


        Assert.assertEquals(result, 5, "Sum should be 5");
    }
}
