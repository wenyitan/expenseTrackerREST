package com.wens.expenseTracker;

import com.wens.expenseTracker.models.Transaction;
import com.wens.expenseTracker.repositories.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import java.io.*;


@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    private TransactionRepo transactionRepo;
    @Override
    public void run(ApplicationArguments args) throws Exception {
//        String userDir = System.getProperty("user.dir");
//        BufferedReader reader = new BufferedReader(new FileReader(userDir + "/transactions.csv"));
//        String line;
//        String firstLine = reader.readLine();
//        while ((line = reader.readLine()) != null) {
//            Transaction newTransaction;
//            if (line.endsWith("\"")) {
//                String[] transactionDetails = line.split("\"");
//                String remarks = transactionDetails[1];
//                String[] remainingDetails = transactionDetails[0].split(",");
//                String person = remainingDetails[0];
//                String transactionType = remainingDetails[1];
//                float amount = Float.parseFloat(remainingDetails[2]);
//                String date = remainingDetails[3];
//                String category = remainingDetails[4];
//
//                newTransaction = new Transaction(person, transactionType, amount, date, category, remarks);
//            } else {
//                String[] transactionDetails = line.split(",");
//                if (line.endsWith(",")) {
//                    newTransaction = new Transaction(transactionDetails[0], transactionDetails[1], Float.parseFloat(transactionDetails[2]), transactionDetails[3], transactionDetails[4], "");
//                } else {
//                    newTransaction = new Transaction(transactionDetails[0], transactionDetails[1], Float.parseFloat(transactionDetails[2]), transactionDetails[3], transactionDetails[4], transactionDetails[5]);
//                }
//            }
//            transactionRepo.save(newTransaction);
//        }

    }
}
