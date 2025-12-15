package com.example.testgrouping;

import org.testng.annotations.Test;

public class signupTests {
    


    @Test(priority=1, groups ={"regression"})
void signupByEmail()
{
    System.out.println("sign by email...");
}

@Test(priority=2, groups ={"regression"})
void signupByFacebook()
{
    System.out.println("Login by facebook...");
}

@Test(priority=3, groups ={"regression"})
void signupByTwitter()
{
    System.out.println("Login by twitter...");
}

}
