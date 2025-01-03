package com.pharmacy.pharmacy_billing.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String medicineDetails;
    private double totalAmount;
    private String date;

    // Default constructor
    public Transaction() {}

    // Parameterized constructor
    public Transaction(String customerName, String medicineDetails, double totalAmount, String date) {
        this.customerName = customerName;
        this.medicineDetails = medicineDetails;
        this.totalAmount = totalAmount;
        this.date = date;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getMedicineDetails() {
        return medicineDetails;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getDate() {
        return date;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setMedicineDetails(String medicineDetails) {
        this.medicineDetails = medicineDetails;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // toString method
    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", medicineDetails='" + medicineDetails + '\'' +
                ", totalAmount=" + totalAmount +
                ", date='" + date + '\'' +
                '}';
    }
}
