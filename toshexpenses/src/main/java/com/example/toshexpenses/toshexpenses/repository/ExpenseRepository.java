package com.example.toshexpenses.toshexpenses.repository;

import com.example.toshexpenses.toshexpenses.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
