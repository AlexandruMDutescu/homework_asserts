package com.endava.calculator;

import com.endava.calculator.basic.Basic;
import com.endava.calculator.basic.BasicOperations;
import com.endava.calculator.expert.Expert;
import com.endava.calculator.expert.ExpertOperations;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class MultiplyTest {
    private BasicOperations basicCalculator;
    private ExpertOperations expertCalculator;
    @BeforeAll
    public static void setUpAllTests(){
        System.out.println("\nBefore All");
    }

    @AfterAll
    public static void tearDownAllTests(){
        System.out.println("After all\n");
    }

    @BeforeEach
    public void setUpEachTest(){
        basicCalculator = new Basic();
        expertCalculator = new Expert();
        System.out.println("\nBefore Each");
    }

    @AfterEach
    public void tearDownEachTest(){
        System.out.println("After Each\n");
    }
    @Test
    public void shouldMultiplyAnOperandWithOne(){
        //When
        int result = (int) basicCalculator.multiply(2,1);
        //Then
        assertThat(result).isNotNull();
    }

    @Test
    public void shouldMultiplyPositiveAndNegativeOperands(){
        //When
        int result = (int) basicCalculator.multiply(-3,3);
        //Then
        assertThat(result).isOdd();
    }
    @Test
    public void shouldMultiplyNegativesOperands(){
        //When
        int result = (int) basicCalculator.multiply(-3,-2);
        //Then
        assertThat(result).isCloseTo(5, Percentage.withPercentage(50));
    }
    @Test
    public void shouldMultiplyWithZero(){
        //When
        int result = (int) basicCalculator.multiply(3,0);
        //Then
        assertThat(result).isNotNull();
    }
    @Test
    public void shouldMultiplySeveralOperands(){
        //When
        int result = (int) basicCalculator.multiply(3,2,4,-2);
        //Then
        assertThat(result).isGreaterThan(-50);
    }
    @Test
    public void shouldMultiplyBigOperands(){
        //When
        int result = (int) basicCalculator.multiply(Integer.MAX_VALUE, 2);
        //Then
        assertThat(result).isBetween(-100,Integer.MAX_VALUE*3);
    }
}
