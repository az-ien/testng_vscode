package com.example.testgrouping;

import org.testng.annotations.Test;

public class paymenttests {
@Test(priority=1, groups ={"sanity","regression","functional"})
void paymentinruppees()
{
    System.out.println("payment in ruppees...");
}

@Test(priority=2, groups ={"sanity","regression"})
void paymentindollars()
{
    System.out.println("payment in dollars");
}

    
}
