package com.wens.expenseTracker.services;

import com.wens.expenseTracker.models.Transaction;
import com.wens.expenseTracker.repositories.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    TransactionRepo transactionRepo;

    public List<Transaction> retrieveAllTransactions() {
        return transactionRepo.findAll();
    }

    public Transaction saveTransaction(Transaction transactionToSave) {
        return transactionRepo.save(transactionToSave);
    }
}
