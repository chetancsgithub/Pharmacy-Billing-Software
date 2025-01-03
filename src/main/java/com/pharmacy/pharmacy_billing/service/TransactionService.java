package com.pharmacy.pharmacy_billing.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.pharmacy.pharmacy_billing.model.Transaction;
import com.pharmacy.pharmacy_billing.repository.TransactionRepository;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
}
