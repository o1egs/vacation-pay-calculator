package ru.shtyrev.vacationpaycalculator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.shtyrev.vacationpaycalculator.exception.CaculatorException;
import ru.shtyrev.vacationpaycalculator.service.CalculatorService;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class CalculatorController {
    private final CalculatorService calculatorService;

    @GetMapping("/calculate")
    public ResponseEntity<Integer> calculate(@RequestParam Integer averageSalary,
                                             @RequestParam Integer dayCount,
                                             @RequestParam(required = false) LocalDate startDate) throws CaculatorException {
        Integer vacationPay = calculatorService.calculate(averageSalary, dayCount, startDate);
        return new ResponseEntity<>(vacationPay, HttpStatus.OK);
    }
}
