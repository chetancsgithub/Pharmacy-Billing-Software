package com.pharmacy.pharmacy_billing.repository;



import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pharmacy.pharmacy_billing.model.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {
    @Query("SELECT m FROM Medicine m WHERE m.quantity < :threshold")
    List<Medicine> findByStockLessThan(@Param("threshold") int threshold);

    List<Medicine> findByExpiryDateBefore(LocalDate date);

    Optional<Medicine> findByNameAndManufacturer(String name, String manufacturer);

    Optional<Medicine> findByName(String name);

    
}
