package com.example.finance_backend.repository;

import com.example.finance_backend.entity.FinancialRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface FinancialRecordRepository extends JpaRepository<FinancialRecord, Long> {
    //now spring will automatically creates queries with no sql writing needed
    List<FinancialRecord> findByType(String type);

    List<FinancialRecord> findByCategory(String category);

    List<FinancialRecord> findByDate(LocalDate date);
}