package com.example.finance_backend.service;
import com.example.finance_backend.entity.FinancialRecord;
import com.example.finance_backend.repository.FinancialRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FinancialRecordService {

    private final FinancialRecordRepository repository;
    //create record in db
    public FinancialRecord create(FinancialRecord record){  return repository.save(record);
    }
    //retrive from db
    public List<FinancialRecord> getAll(){
        return repository.findAll();
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
    //now we can do filterings if want to get data by category,type etc

    public List<FinancialRecord> getByType(String type) {
        return repository.findByType(type);
    }

    public List<FinancialRecord> getByCategory(String category) {
        return repository.findByCategory(category);
    }

    public List<FinancialRecord> getByDate(LocalDate date) {
        return repository.findByDate(date);
    }
}