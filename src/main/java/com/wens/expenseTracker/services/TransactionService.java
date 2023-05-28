package com.wens.expenseTracker.services;

import com.wens.expenseTracker.exceptions.TransactionNotFoundException;
import com.wens.expenseTracker.models.Transaction;
import com.wens.expenseTracker.repositories.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Transaction retrieveTransaction(long transactionId) throws Throwable {
        Optional<Transaction> foundTransaction = transactionRepo.findById(transactionId);
        return foundTransaction.orElseThrow(()-> new TransactionNotFoundException("Transaction with id = " + transactionId + " not found."));
    }

    public Transaction updateTransaction(long transactionId, Transaction editedTransaction) throws TransactionNotFoundException {
        Transaction foundTransaction = transactionRepo.findById(transactionId).orElseThrow(()-> new TransactionNotFoundException("Transaction with id = " + transactionId + " not found."));
        foundTransaction.setTransactionType(editedTransaction.getTransactionType());
        foundTransaction.setCategory(editedTransaction.getCategory());
        foundTransaction.setAmount(editedTransaction.getAmount());
        foundTransaction.setPerson(editedTransaction.getPerson());
        foundTransaction.setRemarks(editedTransaction.getRemarks());
        foundTransaction.setDate(editedTransaction.getDate());
        return transactionRepo.save(foundTransaction);
    }

    public void deleteTransactionById(long transactionId) throws TransactionNotFoundException {
        Transaction foundTransaction = transactionRepo.findById(transactionId).orElseThrow(()-> new TransactionNotFoundException("Transaction with id = " + transactionId + " not found."));
        transactionRepo.deleteById(transactionId);
    }
}
