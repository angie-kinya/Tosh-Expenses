package com.example.toshexpenses.toshexpenses.controller;

import com.example.toshexpenses.toshexpenses.model.HouseholdExpense;
import com.example.toshexpenses.toshexpenses.service.HouseholdExpenseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/householdexpenses")
public class HouseholdExpenseController {
    private final HouseholdExpenseService householdExpenseService;

    public HouseholdExpenseController(HouseholdExpenseService householdExpenseService) {
        this.householdExpenseService = householdExpenseService;
    }

    @GetMapping
    public List<HouseholdExpense> getAll() {
        return householdExpenseService.getAllHouseholdExpenses();
    }

    @GetMapping("/{id}")
    public HouseholdExpense getById(@PathVariable Long id) {
        return householdExpenseService.findById(id);
    }

    @PostMapping
    public HouseholdExpense create(@RequestBody HouseholdExpense householdExpense) {
        return householdExpenseService.save(householdExpense);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        householdExpenseService.deleteById(id);
    }
}
