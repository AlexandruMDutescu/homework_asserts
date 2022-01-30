package com.endava.calculator;

import com.endava.calculator.basic.Basic;
import com.endava.calculator.basic.BasicOperations;
import com.endava.calculator.expert.Expert;
import com.endava.calculator.expert.ExpertOperations;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.logging.log4j.core.pattern.NotANumber;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.platform.launcher.core.LauncherFactory;

import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddTest {
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
    @Tags({@Tag("smoke"),@Tag("ui")})
    @ParameterizedTest
    @MethodSource("numberProvider")
    public void shouldAddNumbersGivenOperand0(int a , int b, int expected){
        // GIVEN
        // LauncherFactory.create().registerTestExecutionListeners();
        //WHEN
        int result = basicCalculator.add(a, b);

        //THEN
        assertThat(result, is(expected));

    }
    public static List<Arguments> numberProvider(){
        List<Arguments> argumentList = new ArrayList<>();
        argumentList.add(Arguments.of(0,2,2));
        argumentList.add(Arguments.of(2,0,2));
        return argumentList;
    }

    @Tag("smoke")
    @Test
    public void shouldAddNegativeNumbers(){
        //Given

        //When
        Long result = Long.valueOf(basicCalculator.add(-2, -4));
        //Then
        assertThat(result, is(-6L));
    }
    @Tags({@Tag("smoke"),@Tag("api")})
    @Test
    public void shouldAddBigNumbers(){
            //Given

            //When
            Long result = Long.valueOf(basicCalculator.add(Integer.MAX_VALUE, 1));
            //Then
        assertThat(result, is(Integer.MAX_VALUE));
            }

        @ParameterizedTest
    @CsvSource({"1,2,3","2,4,7"})
//    @CsvFileSource(files = "com.endava.calculator/numberSource.csv")
    public void shouldAddMoreThan2Operands(Integer a1, Integer a2, Integer a3){
        //Given

        //When
        int result = basicCalculator.add(a1,a2,a3);
        //Then
        assertThat(result, instanceOf(Integer.class));
        }

    @Test
    public void shouldAddNoOperands(){
        //Given
        int a=5;
        //When
        int result = basicCalculator.add();
        //Then
        assertThat(result,greaterThanOrEqualTo(3));
    }

    @Test
    public void shouldAddOneOperands(){
        //When
        int result = basicCalculator.add(167);
        //Then
        assertThat(result, not(160));
    }

}
