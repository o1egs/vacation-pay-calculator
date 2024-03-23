package ru.shtyrev.vacationpaycalculator.service.impl;

import org.junit.jupiter.api.Test;
import ru.shtyrev.vacationpaycalculator.exception.CaculatorException;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplTest {
    @Test
    public void testCalculate() throws CaculatorException {
        CalculatorServiceImpl calculator = new CalculatorServiceImpl();
        int result = calculator.calculate(1000, 10, null);
        assertEquals(340, result);
    }

    @Test
    public void testVacationPay() {
        CalculatorServiceImpl calculator = new CalculatorServiceImpl();
        int result = calculator.vacationPay(1000, 10);
        assertEquals(340, result);
    }

    @Test
    public void testIsNotHoliday() {
        CalculatorServiceImpl calculator = new CalculatorServiceImpl();
        LocalDate date = LocalDate.of(2022, 12, 25); // Christmas Day
        boolean result = calculator.isHoliday(date);
        assertFalse(result);
    }

    @Test
    public void testIsHoliday() {
        CalculatorServiceImpl calculator = new CalculatorServiceImpl();
        LocalDate date = LocalDate.of(2022, 12, 31); // Christmas Day
        boolean result = calculator.isHoliday(date);
        assertTrue(result);
    }

    @Test
    public void testIsWeekend() {
        CalculatorServiceImpl calculator = new CalculatorServiceImpl();
        LocalDate date = LocalDate.of(2022, 12, 31); // Saturday
        boolean result = calculator.isWeekend(date);
        assertTrue(result);
    }

    @Test
    public void testCalculateWithStartDate() throws CaculatorException {
        CalculatorServiceImpl calculator = new CalculatorServiceImpl();
        int result = calculator.calculate(1000, 10, LocalDate.of(2022, 12, 24));
        System.out.println(result);
        assertEquals(204, result);
    }
}