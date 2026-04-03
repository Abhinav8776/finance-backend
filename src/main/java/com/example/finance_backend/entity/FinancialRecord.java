package com.example.finance_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinancialRecord{
    @Id
    @GeneratedValue
    private Long id;
    private double amount;

    private String type;// type like its income or expense

    private String category;// for eg rent food

    private LocalDate date;

    private String note;
}