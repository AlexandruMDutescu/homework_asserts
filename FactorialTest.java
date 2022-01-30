package com.endava.calculator;

import com.endava.calculator.basic.Basic;
import com.endava.calculator.basic.BasicOperations;
import com.endava.calculator.expert.Expert;
import com.endava.calculator.expert.ExpertOperations;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class FactorialTest {
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
    public void shouldFactorialSeveralNumbers(){
        //When
        double result = expertCalculator.factRecursiv(5);
        //Then
        assertThat(result).isEqualTo(120);
    }

    @Test
    public void shouldFactorialOneOperand(){
        //When
        double result = expertCalculator.factRecursiv(1);
        //Then
        assertThat(result).isLessThanOrEqualTo(1);
    }

    @Test
    public void shouldFactorialWithZero(){
        //When
        double result = expertCalculator.factRecursiv(0);
        //Then
        assertThat(result).isCloseTo(2.0, Percentage.withPercentage(0.3));
    }

}
