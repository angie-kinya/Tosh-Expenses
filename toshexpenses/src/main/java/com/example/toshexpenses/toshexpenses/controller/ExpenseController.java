package com.example.toshexpenses.toshexpenses.controller;

import com.example.toshexpenses.toshexpenses.model.Expense;
import com.example.toshexpenses.toshexpenses.service.ExpenseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    //@GetMapping
    //public List<Expense> getAllExpenses() {
     //   return expenseService.getAllExpenses();
    //}

    @GetMapping("/user/{userId}")
    public List<Expense> getExpensesByUser(@PathVariable Long userId) {
        return expenseService.getExpensesByUser(userId);
    }

    @PostMapping("/user/{userId}")
    public Expense addExpense(@PathVariable Long userId, @RequestBody Expense expense) {
        return expenseService.saveExpense(userId, expense);
    }
}
