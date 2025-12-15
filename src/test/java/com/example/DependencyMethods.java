package com.example;

import org.junit.Assert;
import org.testng.annotations.Test;



// all of these methods are depenedent on previous methods

public class DependencyMethods {
    
    @Test(priority=1)
    void openapp()
    {
        // false failed this but other tests were run as testng ran all the tests but if login fails how can others run ????
    Assert.assertTrue(true);
    }

    @Test(priority=2, dependsOnMethods={"openapp"})
    void login()
    {
        Assert.assertTrue(true);

    }

    @Test(priority=3, dependsOnMethods={"login"})
    void search()
    {
    Assert.assertTrue(false);
    }

    @Test(priority=4, dependsOnMethods={"search","login"}) // both should be true only then will this run, this is an and condition of both
    void advsearch()
    {
    Assert.assertTrue(true);
    }

    @Test(priority=5, dependsOnMethods={"advsearch"})
    void logut()
    {
    Assert.assertTrue(true);
    }
    
}
