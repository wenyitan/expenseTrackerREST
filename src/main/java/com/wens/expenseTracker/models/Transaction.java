package com.wens.expenseTracker.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transactionId;
    private String person;
    private String transactionType;
    private float amount;
    private String date;
    private String category;
    private String remarks;

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Transaction() {
        super();
    }

    public Transaction(String person, String transactionType, float amount, String date, String category, String remarks) {
        this.person = person;
        this.transactionType = transactionType;
        this.amount = amount;
        this.date = date;
        this.category = category;
        this.remarks = remarks;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", person='" + person + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                ", category='" + category + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
