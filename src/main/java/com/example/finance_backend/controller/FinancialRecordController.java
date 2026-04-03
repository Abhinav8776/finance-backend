package com.example.finance_backend.controller;
import com.example.finance_backend.entity.FinancialRecord;
import com.example.finance_backend.service.FinancialRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/records")
@RequiredArgsConstructor
public class FinancialRecordController {

    private final FinancialRecordService service;
   // create new financial record
    @PostMapping
    public FinancialRecord create(@RequestBody FinancialRecord record) {
        return service.create(record);
    }
    //list all records
    @GetMapping
    public List<FinancialRecord> getAll() {
        return service.getAll();
    }
   //delete by id
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
    // filter by type
    @GetMapping("/type/{type}")
    public List<FinancialRecord> getByType(@PathVariable String type) {
        return service.getByType(type);
    }

    // filter by category
    @GetMapping("/category/{category}")
    public List<FinancialRecord> getByCategory(@PathVariable String category) {
        return service.getByCategory(category);
    }

    // filter by date
    @GetMapping("/date/{date}")
    public List<FinancialRecord> getByDate(@PathVariable String date) {
        return service.getByDate(LocalDate.parse(date));
    }
}