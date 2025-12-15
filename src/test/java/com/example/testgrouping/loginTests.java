package com.example.testgrouping;


import org.testng.annotations.Test;



public class loginTests {
    


    
@Test(priority=1, groups ={"sanity"})
void loginByEmail()
{
    System.out.println("Login by email...");
}


@Test(priority=2, groups ={"sanity"})
void loginByFacebook()
{
    System.out.println("Login by facebook...");
}



}


