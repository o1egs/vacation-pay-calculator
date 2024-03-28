package ru.shtyrev.vacationpaycalculator.service.impl;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CheckDaysUtilImplTest {
    @Test
    public void testIsNotHoliday() {
        CheckDaysUtilImpl checkDaysUtil = new CheckDaysUtilImpl();
        LocalDate date = LocalDate.of(2022, 12, 25); // Christmas Day
        boolean result = checkDaysUtil.isHoliday(date);
        assertFalse(result);
    }

    @Test
    public void testIsHoliday() {
        CheckDaysUtilImpl checkDaysUtil = new CheckDaysUtilImpl();
        LocalDate date = LocalDate.of(2022, 12, 31); // Christmas Day
        boolean result = checkDaysUtil.isHoliday(date);
        assertTrue(result);
    }

    @Test
    public void testIsWeekend() {
        CheckDaysUtilImpl checkDaysUtil = new CheckDaysUtilImpl();
        LocalDate date = LocalDate.of(2022, 12, 31); // Saturday
        boolean result = checkDaysUtil.isWeekend(date);
        assertTrue(result);
    }
}