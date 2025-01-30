package com.example.toshexpenses.toshexpenses.service;

import com.example.toshexpenses.toshexpenses.model.Expense;
import com.example.toshexpenses.toshexpenses.model.User;
import com.example.toshexpenses.toshexpenses.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final UserService userService;

    public ExpenseService(ExpenseRepository expenseRepository, UserService userService) {
        this.expenseRepository = expenseRepository;
        this.userService = userService;
    }

    public Expense saveExpense(Long userId, Expense expense) {
        User user = userService.getUserById(userId);
        expense.setUser(user);
        return expenseRepository.save(expense);
    }

    public List<Expense> getExpensesByUser(Long userId) {
        User user = userService.getUserById(userId);
        return expenseRepository.findAll().stream()
                .filter(expense -> expense.getUser().equals(user))
                .toList();
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

}
