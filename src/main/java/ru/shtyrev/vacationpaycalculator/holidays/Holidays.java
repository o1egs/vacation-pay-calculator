package ru.shtyrev.vacationpaycalculator.holidays;

import lombok.Getter;

import java.time.Month;

import static java.time.Month.*;

@Getter
public enum Holidays {
    DEFENDERS_DAY(23, FEBRUARY),
    WOMEN_DAY(8, MARCH),
    LABOR_DAY(1, MAY),
    VICTORY_DAY(9, MAY),
    NEW_YEAR(31, DECEMBER);

    private final Integer day;
    private final Month month;

    Holidays(Integer day, Month month) {
        this.day = day;
        this.month = month;
    }
}
