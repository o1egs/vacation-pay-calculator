package ru.shtyrev.vacationpaycalculator.service.impl;

import org.springframework.stereotype.Service;
import ru.shtyrev.vacationpaycalculator.holidays.Holidays;
import ru.shtyrev.vacationpaycalculator.service.CheckDaysUtil;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

@Service
public class CheckDaysUtilImpl implements CheckDaysUtil {
    @Override
    public boolean isHoliday(LocalDate date) {
        int day = date.getDayOfMonth();
        Month month = date.getMonth();
        for (Holidays holiday : Holidays.values()) {
            Integer holidayDay = holiday.getDay();
            Month holidayMonth = holiday.getMonth();
            if (holidayDay.equals(day) && holidayMonth.equals(month)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isWeekend(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek.equals(SUNDAY) || dayOfWeek.equals(SATURDAY);
    }
}
