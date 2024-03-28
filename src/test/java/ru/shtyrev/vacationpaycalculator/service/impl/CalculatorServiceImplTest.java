package ru.shtyrev.vacationpaycalculator.service.impl;

import org.junit.jupiter.api.Test;
import ru.shtyrev.vacationpaycalculator.exception.CaculatorException;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplTest {
    @Test
    public void testCalculate() throws CaculatorException {
        CheckDaysUtilImpl checkDaysUtil = new CheckDaysUtilImpl();
        CalculatorServiceImpl calculator = new CalculatorServiceImpl(checkDaysUtil);
        int result = calculator.calculate(1000, 10, null);
        assertEquals(340, result);
    }

    @Test
    public void testVacationPay() {
        CheckDaysUtilImpl checkDaysUtil = new CheckDaysUtilImpl();
        CalculatorServiceImpl calculator = new CalculatorServiceImpl(checkDaysUtil);
        int result = calculator.vacationPay(1000, 10);
        assertEquals(340, result);
    }

    @Test
    public void testCalculateWithStartDate() throws CaculatorException {
        CheckDaysUtilImpl checkDaysUtil = new CheckDaysUtilImpl();
        CalculatorServiceImpl calculator = new CalculatorServiceImpl(checkDaysUtil);
        int result = calculator.calculate(1000, 10, LocalDate.of(2022, 12, 24));
        System.out.println(result);
        assertEquals(204, result);
    }
}