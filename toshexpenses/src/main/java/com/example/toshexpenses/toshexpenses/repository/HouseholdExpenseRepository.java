package com.example.toshexpenses.toshexpenses.repository;

import com.example.toshexpenses.toshexpenses.model.HouseholdExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseholdExpenseRepository extends JpaRepository<HouseholdExpense, Long> {
}
