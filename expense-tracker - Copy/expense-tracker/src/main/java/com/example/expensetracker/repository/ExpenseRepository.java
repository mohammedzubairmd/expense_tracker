package com.example.expensetracker.repository;

import com.example.expensetracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    @Query("SELECT e.type, SUM(e.amount) FROM Expense e GROUP BY e.type")
    List<Object[]> getIncomeVsExpenseSummary();

    @Query("SELECT e.category, SUM(e.amount) FROM Expense e WHERE e.type = 'EXPENSE' GROUP BY e.category")
    List<Object[]> getCategoryExpenseSummary();
}