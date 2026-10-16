package vn.vti;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCalculate {

    private static final Logger logger =
            Logger.getLogger(TestCalculate.class.getName());

    private static Calculator calculator;

    // Chạy một lần trước tất cả test case
    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
        logger.info("Initialize Calculator object");
    }

    // Chạy trước mỗi test case
    @BeforeEach
    void beforeEach() {
        logger.info("Prepare for test");
    }

    // Test phép cộng
    @Test
    void testAdd() {
        int result = calculator.add(0, 2);

        Assertions.assertEquals(2, result);
        logger.info("testAdd passed");
    }

    // Test phép trừ
    @Test
    void testMinus() {
        int result = calculator.minus(5, 2);

        Assertions.assertEquals(3, result);
        logger.info("testMinus passed");
    }

    // Chạy một lần sau tất cả test case
    @AfterAll
    static void afterAll() {
        calculator = null;
        logger.info("Calculator reference cleared");
    }

//    @ParameterizedTest
//    @CsvFileSource(files = "src/test/resources/fruit.csv", numLinesToSkip = 1)
//    void testWithCsvFileSour

    @ParameterizedTest
    @MethodSource(value = "vn.vti.DataProviderMethod#students")
    void testWithCsvFileSour(String student) {
        assertFalse(student.isEmpty());
    }

    @ParameterizedTest
    @ArgumentsSource(value = MyDataProvider.class)
    void testWithArgumentSour(int number) {
//        assertFalse(number.isEmpty());
    }

}