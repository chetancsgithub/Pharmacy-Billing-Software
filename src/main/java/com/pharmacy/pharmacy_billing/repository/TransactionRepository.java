package com.pharmacy.pharmacy_billing.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.pharmacy.pharmacy_billing.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}

