package ru.shtyrev.vacationpaycalculator.service;

import ru.shtyrev.vacationpaycalculator.exception.CaculatorException;

import java.time.LocalDate;

public interface CalculatorService {
    Integer calculate(Integer averageSalary,
                      Integer dayCount,
                      LocalDate startDate) throws CaculatorException;
}
