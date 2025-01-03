package com.pharmacy.pharmacy_billing.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;
    private String manufacturer;
    private int quantity;
    private double price;
    private int stock;
    private LocalDate expiryDate;
    private double mrpIncludingGst;
    private double purchaseRateExcludingGst;
    private double gstRate;
    private boolean purchaseRateIncludesGst;

    

    // Default constructor
    public Medicine() {}

    // Parameterized constructor
    public Medicine(String name, String category, String manufacturer, int quantity, double price,
                    LocalDate expiryDate, double mrpIncludingGst, double purchaseRateExcludingGst,
                    double gstRate, boolean purchaseRateIncludesGst) {
        this.name = name;
        this.category = category;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
        this.price = price;
        this.expiryDate = expiryDate;
        this.mrpIncludingGst = mrpIncludingGst;
        this.purchaseRateExcludingGst = purchaseRateExcludingGst;
        this.gstRate = gstRate;
        this.purchaseRateIncludesGst = purchaseRateIncludesGst;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public double getMrpIncludingGst() {
        return mrpIncludingGst;
    }

    public void setMrpIncludingGst(double mrpIncludingGst) {
        this.mrpIncludingGst = mrpIncludingGst;
    }

    public double getPurchaseRateExcludingGst() {
        return purchaseRateExcludingGst;
    }



    public void setPurchaseRateExcludingGst(double purchaseRateExcludingGst) {
        this.purchaseRateExcludingGst = purchaseRateExcludingGst;
    }

    public double getGstRate() {
        return gstRate;
    }

    public void setGstRate(double gstRate) {
        this.gstRate = gstRate;
    }

    public boolean isPurchaseRateIncludesGst() {
        return purchaseRateIncludesGst;
    }

    public void setPurchaseRateIncludesGst(boolean purchaseRateIncludesGst) {
        this.purchaseRateIncludesGst = purchaseRateIncludesGst;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", stock=" + stock +
                ", expiryDate=" + expiryDate +
                ", mrpIncludingGst=" + mrpIncludingGst +
                ", purchaseRateExcludingGst=" + purchaseRateExcludingGst +
                ", gstRate=" + gstRate +
                ", purchaseRateIncludesGst=" + purchaseRateIncludesGst +
                '}';
    }

    
}
