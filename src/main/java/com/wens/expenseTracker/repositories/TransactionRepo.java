package com.wens.expenseTracker.repositories;

import com.wens.expenseTracker.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {
}
