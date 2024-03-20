package ru.shtyrev.vacationpaycalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.shtyrev.vacationpaycalculator.service.CalculatorService;
import ru.shtyrev.vacationpaycalculator.service.impl.CalculatorServiceImpl;

import java.time.LocalDate;

@SpringBootApplication
public class VacationPayCalculatorApplication implements CommandLineRunner {
    @Autowired
    CalculatorServiceImpl calculatorService;

    public static void main(String[] args) {
        SpringApplication.run(VacationPayCalculatorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(calculatorService.calculate(1_00_000, 10, LocalDate.of(2024, 3, 1)));
    }
}
