package com.example.finance_backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinancialRecord {

    @Id
    @GeneratedValue
    private Long id;

    // Amount must be positive (prevents invalid financial data)
    @Positive(message = "Amount must be positive")
    private double amount;

    // Restrict type to only INCOME or EXPENSE
    @NotBlank(message = "Type is required")
    @Pattern(regexp = "INCOME|EXPENSE", message = "Type must be INCOME or EXPENSE")
    private String type;

    // Category should not be empty (e.g., Food, Rent, Salary)
    @NotBlank(message = "Category is required")
    private String category;

    // Date must be provided
    @NotNull(message = "Date is required")
    private LocalDate date;

    private String note;
}