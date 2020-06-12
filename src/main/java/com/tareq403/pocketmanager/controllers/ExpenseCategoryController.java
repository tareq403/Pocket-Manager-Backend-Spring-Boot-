package com.tareq403.pocketmanager.controllers;

import com.tareq403.pocketmanager.models.ExpenseCategory;
import com.tareq403.pocketmanager.repositories.ExpenseCategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpenseCategoryController {
    private ExpenseCategoryRepository repository;

    public ExpenseCategoryController(ExpenseCategoryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/expense-category")
    List<ExpenseCategory> findAll() {
        return this.repository.findAll();
    }

    @GetMapping("/expense-category/{id}")
    ExpenseCategory findById(@PathVariable String id) {
        return this.repository.findById(id).orElseThrow(() -> new RuntimeException("Not found."));
    }

    @PostMapping("/expense-category")
    ExpenseCategory save(@RequestBody ExpenseCategory expenseCategory) {
        return this.repository.save(expenseCategory);
    }

    @PutMapping("/expense-category/{id}")
    ExpenseCategory findByIdAndUpdate(@RequestBody ExpenseCategory newExpenseCategory, @PathVariable String id) {
        return this.repository.findById(id)
                .map(expenseCategory -> {
                    expenseCategory.setName(newExpenseCategory.getName());
                    return this.repository.save(expenseCategory);
                })
                .orElseGet(() -> {
                    newExpenseCategory.setId(id);
                    return this.repository.save(newExpenseCategory);
                });
    }

    @DeleteMapping("/expense-category/{id}")
    void findByIdAndDelete(@PathVariable String id) {
        this.findByIdAndDelete(id);
    }
}
