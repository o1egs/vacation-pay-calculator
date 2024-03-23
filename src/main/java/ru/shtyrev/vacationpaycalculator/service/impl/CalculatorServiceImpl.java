package ru.shtyrev.vacationpaycalculator.service.impl;

import org.springframework.stereotype.Service;
import ru.shtyrev.vacationpaycalculator.exception.CaculatorException;
import ru.shtyrev.vacationpaycalculator.holidays.Holidays;
import ru.shtyrev.vacationpaycalculator.service.CalculatorService;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

import static java.time.DayOfWeek.*;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public Integer calculate(Integer averageSalary, Integer dayCount, LocalDate startDate) throws CaculatorException {
        validate(averageSalary, dayCount);
        if (startDate == null) {
            return vacationPay(averageSalary, dayCount);
        }

        int finalDayCount = dayCount;
        LocalDate date = startDate;
        int days = dayCount;

        while (days > 0) {
            boolean flag = isHoliday(date) || isWeekend(date);
            finalDayCount = flag ? finalDayCount - 1 : finalDayCount;
            date = date.plusDays(1);
            days--;
        }
        return vacationPay(averageSalary, finalDayCount);
    }

    int vacationPay(Integer averageSalary, Integer dayCount) {
        return (int) ((averageSalary / 29.4) * dayCount);
    }

    private void validate(Integer averageSalary, Integer dayCount) throws CaculatorException {
        if (averageSalary < 0) throw new CaculatorException("Salary < 0");
        if (dayCount < 0) throw new CaculatorException("Day count < 0");
    }

    boolean isHoliday(LocalDate date) {
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

    boolean isWeekend(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek.equals(SUNDAY) || dayOfWeek.equals(SATURDAY);
    }
}
