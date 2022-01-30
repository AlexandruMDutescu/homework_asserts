package com.endava.calculator;

import com.endava.calculator.basic.Basic;
import com.endava.calculator.basic.BasicOperations;
import com.endava.calculator.expert.Expert;
import com.endava.calculator.expert.ExpertOperations;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class PowTest {
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
    public void shouldPowTwoOperands(){
        //When
        int result = (int) expertCalculator.pow(2,3);
        //Then
        assertThat(result).isEven();
    }

    @Test
    public void shouldPowExponentOne(){
        //When
        int result = (int) expertCalculator.pow(5,1);
        //Then
        assertThat(result).isEqualByComparingTo(5);
    }

    @Test
    public void shouldPowBazeOne(){
        //When
        int result = (int) expertCalculator.pow(0,2);
        //Then
        assertThat(result).isNotCloseTo(2, Percentage.withPercentage(70));
    }

    @Test
    public void shouldPowNegativeBase(){
        //When
        int result = (int) expertCalculator.pow(-2,2);
        //Then
        assertThat(result).isNotNegative();
    }
    @Test
    public void shouldPowWithExponentZero(){
        //When
        int result = (int) expertCalculator.pow(2,0);
        //Then
        assertThat(result).isEqualTo(1);
    }
}
