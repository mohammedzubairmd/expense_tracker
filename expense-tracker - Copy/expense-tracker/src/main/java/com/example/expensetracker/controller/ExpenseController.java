package com.example.expensetracker.controller;

import com.example.expensetracker.model.Expense;
import com.example.expensetracker.repository.ExpenseRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseRepository repository;

    public ExpenseController(ExpenseRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Expense add(@RequestBody Expense expense) {
        return repository.save(expense);
    }

    @GetMapping
    public List<Expense> getAll() {
        return repository.findAll();
    }
    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id) {
        repository.deleteById(id);
    }
    @GetMapping("/export")
    public void exportToCSV(jakarta.servlet.http.HttpServletResponse response) throws java.io.IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=expenses_report.csv");

        java.io.PrintWriter writer = response.getWriter();
        writer.println("Date,Title,Category,Type,Amount");

        for (Expense e : repository.findAll()) {
            writer.println(e.getDate() + "," + e.getTitle() + "," + e.getCategory() + "," + e.getType() + "," + e.getAmount());
        }
    }
}