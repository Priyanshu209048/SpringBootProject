package com.testing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class Calculator {

    //Sum
    //@Bean
    public int doSum(int a, int b, int c) {
        return a + b + c;
    }

    //Product
    public int doProduct(int a, int b) {
        return a * b;
    }

    //Compare
    public Boolean compareTwoNumbers(int a, int b) {
        //return a.equals(b); //We return this if we use Integer instead int
        return a == b;
    }

}
