package ru.shtyrev.vacationpaycalculator.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shtyrev.vacationpaycalculator.exception.CaculatorException;
import ru.shtyrev.vacationpaycalculator.service.CalculatorService;
import ru.shtyrev.vacationpaycalculator.service.CheckDaysUtil;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CalculatorServiceImpl implements CalculatorService {
    private final CheckDaysUtil checkDaysUtil;
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
            boolean flag = checkDaysUtil.isHoliday(date) || checkDaysUtil.isWeekend(date);
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
}
