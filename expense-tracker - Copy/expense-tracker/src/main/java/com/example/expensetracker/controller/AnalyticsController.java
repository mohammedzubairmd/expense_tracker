package com.example.expensetracker.controller;

import com.example.expensetracker.repository.ExpenseRepository;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {

    private final ExpenseRepository repository;

    public AnalyticsController(ExpenseRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/dashboard")
    public Map<String, Object> getDashboard() {
        List<Object[]> summary = repository.getIncomeVsExpenseSummary();
        double income = 0;
        double expense = 0;

        for (Object[] row : summary) {
            if (row[0] != null && row[1] != null) {
                String type = row[0].toString();
                double val = ((Number) row[1]).doubleValue();
                if ("INCOME".equalsIgnoreCase(type)) income = val;
                else expense = val;
            }
        }

        Map<String, Object> data = new HashMap<>();
        data.put("totalIncome", income);
        data.put("totalExpense", expense);
        data.put("balance", income - expense);
        return data;
    }
}