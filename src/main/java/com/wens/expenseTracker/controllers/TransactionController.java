package com.wens.expenseTracker.controllers;

import com.wens.expenseTracker.models.Transaction;
import com.wens.expenseTracker.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/expense-tracker")
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    @GetMapping("/transactions")
    public ResponseEntity<List<Transaction>> getAllTransactions(
            @RequestParam(name="person", required = false) String person,
            @RequestParam(name="month_year", required = false) String monthYear) throws ParseException {

        List<Transaction> allTransactions = transactionService.retrieveAllTransactions();
        if (person != null) {
            allTransactions = allTransactions.stream().filter((transaction) -> transaction.getPerson().equals(person)).toList();
        }
        if (monthYear != null) {
            SimpleDateFormat dateFormatForInput = new SimpleDateFormat("MMMM-yyyy");
            SimpleDateFormat dateFormatForTransactions = new SimpleDateFormat("dd/MM/yyyy");
            Date chosenMonthYear = dateFormatForInput.parse(monthYear);
            allTransactions = allTransactions.stream().filter((transaction ->
            {
                try {
                    return dateFormatForTransactions.parse(transaction.getDate()).getMonth() == chosenMonthYear.getMonth() &&
                            dateFormatForTransactions.parse(transaction.getDate()).getYear() == chosenMonthYear.getYear();
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            })).toList();
        }
        return ResponseEntity.ok(allTransactions);
    }

    @PostMapping("/transaction")
    public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transactionToSave) {
        Transaction savedTransaction = transactionService.saveTransaction(transactionToSave);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedTransaction.getTransactionId()).toUri();
        return ResponseEntity.created(location).body(savedTransaction);
    }

}
