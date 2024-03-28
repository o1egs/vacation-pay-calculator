package ru.shtyrev.vacationpaycalculator.service;

import java.time.LocalDate;

public interface CheckDaysUtil {
    boolean isHoliday(LocalDate date);

    boolean isWeekend(LocalDate date);
}
