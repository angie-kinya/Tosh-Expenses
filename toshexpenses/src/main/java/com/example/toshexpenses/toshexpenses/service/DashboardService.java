package com.example.toshexpenses.toshexpenses.service;

import com.example.toshexpenses.toshexpenses.model.Expense;
import com.example.toshexpenses.toshexpenses.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DashboardService {
    private final ExpenseRepository expenseRepository;

    public DashboardService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public Map<String, Object> getDashboardData() {
        Map<String, Object> dashboardData = new HashMap<>();
        List<Expense> allExpenses = expenseRepository.findAll();

        //Individual expenses aggregation
        Map<String, Double> individualExpenses = allExpenses.stream()
                .collect(Collectors.groupingBy(
                        expense -> expense.getUser().getUsername(),
                        Collectors.summingDouble(Expense::getAmount)
                ));

        // Household Expenses Aggregation
        double householdExpense = individualExpenses.values().stream().mapToDouble(Double::doubleValue).sum();

        dashboardData.put("individualExpenses", individualExpenses);
        dashboardData.put("householdExpense", householdExpense);

        return dashboardData;
    }
}
