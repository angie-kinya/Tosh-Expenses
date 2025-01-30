package com.example.toshexpenses.toshexpenses.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class DashboardSummary {
    @Id
    private String id;

    private Long totalUsers;
    private Double totalExpenses;
    private Long categorySummaries;
}
