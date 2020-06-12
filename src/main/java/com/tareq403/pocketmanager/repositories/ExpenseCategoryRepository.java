package com.tareq403.pocketmanager.repositories;

import com.tareq403.pocketmanager.models.ExpenseCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpenseCategoryRepository extends MongoRepository<ExpenseCategory, String> {
}
