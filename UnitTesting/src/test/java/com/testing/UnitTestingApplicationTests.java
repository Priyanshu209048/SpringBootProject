package com.testing;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

//@SpringBootTest annotation loads the complete Spring Boot application context,
// but if we didn't use this annotation then it only test the beans which is available in this class rather than the application context.
//@Test annotation only loads beans required to test a particular layer.
//@SpringBootTest
class UnitTestingApplicationTests {

    /*@Autowired
    private Calculator c;*/
    private Calculator c = new Calculator();

    @Test
    void contextLoads() {
    }

    @Test
    @Disabled //This annotation is used if we don't want to test the method
    void testSum(){
        //expected
        int expectedResult = 60;
        //actual result
        int actualResult = c.doSum(10, 20, 30);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void testProduct(){
        //expected
        int expectedResult = 200;
        //actual result
        int actualResult = c.doProduct(10, 20);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void testCompareNums(){
        //actual result
        Boolean actualResult = c.compareTwoNumbers(3, 3);
        assertThat(actualResult).isTrue();
    }

}
