package com.example.finance_backend.service;
import com.example.finance_backend.entity.FinancialRecord;
import com.example.finance_backend.repository.FinancialRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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
}