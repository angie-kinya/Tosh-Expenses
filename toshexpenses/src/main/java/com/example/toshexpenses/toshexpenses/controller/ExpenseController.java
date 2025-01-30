package com.example.toshexpenses.toshexpenses.controller;

import com.example.toshexpenses.toshexpenses.model.Expense;
import com.example.toshexpenses.toshexpenses.model.User;
import com.example.toshexpenses.toshexpenses.service.ExpenseService;
import com.example.toshexpenses.toshexpenses.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    private final ExpenseService expenseService;
    private final UserService userService;

    public ExpenseController(ExpenseService expenseService, UserService userService) {
        this.expenseService = expenseService;
        this.userService = userService;
    }

    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @GetMapping("/view-expenses/{userId}")
    public List<Expense> getExpensesByUser(@PathVariable Long userId) {
        return expenseService.getExpensesByUser(userId);
    }

//    @PostMapping("/create")
//    public ResponseEntity<?> addExpense(@RequestParam Long userId, @RequestBody Expense expense) {
//        Optional<User> user = Optional.ofNullable(userService.getUserById(userId));
//        if (user.isEmpty()) {
//            return ResponseEntity.badRequest().body("Invalid user ID");
//        }
//        Expense savedExpense = expenseService.saveExpense(userId, expense);
//        return ResponseEntity.ok(savedExpense);
//    }

    @PostMapping("/create")
    public ResponseEntity<?> addExpense(@RequestParam Long userId, @RequestBody Expense expense) {
        Expense savedExpense = expenseService.saveExpense(userId, expense);
        return ResponseEntity.ok(savedExpense);
    }

//    @PostMapping("/create")
//    public ResponseEntity<?> addExpense(@RequestParam Long userId, @RequestBody Expense expense) {
//        if (userId == null) {
//            return ResponseEntity.badRequest().body("User ID is required");
//        }
//        Expense savedExpense = expenseService.saveExpense(userId, expense);
//        return ResponseEntity.ok(savedExpense);
//    }
}
