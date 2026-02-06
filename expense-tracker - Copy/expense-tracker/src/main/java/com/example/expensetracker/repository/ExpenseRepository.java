package com.example.expensetracker.repository;

import com.example.expensetracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    @Query("SELECT e.type, SUM(e.amount) FROM Expense e GROUP BY e.type")
    List<Object[]> getIncomeVsExpenseSummary();

    @Query("SELECT e.category, SUM(e.amount) FROM Expense e WHERE e.type = 'EXPENSE' GROUP BY e.category")
    List<Object[]> getCategoryExpenseSummary();

    @Query("SELECT e.date, e.type, SUM(e.amount) FROM Expense e GROUP BY e.date, e.type")
    List<Object[]> getDailySummary();

    // NEW: Get current month's spending by category
    @Query("SELECT e.category, SUM(e.amount) FROM Expense e WHERE e.type = 'EXPENSE' " +
            "AND MONTH(e.date) = :month AND YEAR(e.date) = :year GROUP BY e.category")
    List<Object[]> getMonthlyCategorySpending(@Param("month") int month, @Param("year") int year);

    // Add this to your ExpenseRepository.java interface
    @Query("SELECT e.date, " +
            "SUM(CASE WHEN e.type = 'INCOME' THEN e.amount ELSE -e.amount END) " +
            "FROM Expense e GROUP BY e.date ORDER BY e.date ASC")
    List<Object[]> getDailyBalanceTrend();
}
