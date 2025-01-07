package com.example.toshexpenses.toshexpenses.service;

import com.example.toshexpenses.toshexpenses.model.HouseholdExpense;
import com.example.toshexpenses.toshexpenses.repository.HouseholdExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseholdExpenseService {
    private final HouseholdExpenseRepository householdExpenseRepository;

    public HouseholdExpenseService(HouseholdExpenseRepository householdExpenseRepository) {
        this.householdExpenseRepository = householdExpenseRepository;
    }

    public List<HouseholdExpense> getAllHouseholdExpenses() {
        return householdExpenseRepository.findAll();
    }

    public HouseholdExpense save(HouseholdExpense householdExpense) {
        return householdExpenseRepository.save(householdExpense);
    }

    public HouseholdExpense findById(Long id) {
        return householdExpenseRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        householdExpenseRepository.deleteById(id);
    }
}
