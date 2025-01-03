package com.pharmacy.pharmacy_billing.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pharmacy.pharmacy_billing.model.Medicine;
import com.pharmacy.pharmacy_billing.repository.MedicineRepository;

@Service
public class MedicineService {
    private final MedicineRepository medicineRepository;

    public MedicineService(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }

    public Medicine saveMedicine(Medicine medicine) {
        // Check if a medicine with the same name and manufacturer already exists
        Optional<Medicine> existingMedicine = medicineRepository.findByNameAndManufacturer(
            medicine.getName(),
            medicine.getManufacturer()
        );
    
        if (existingMedicine.isPresent()) {
            // Update the existing medicine's quantity and other fields
            Medicine existing = existingMedicine.get();
            existing.setQuantity(medicine.getQuantity());
            existing.setCategory(medicine.getCategory());
            existing.setPrice(medicine.getPrice());
            existing.setGstRate(medicine.getGstRate());
            existing.setExpiryDate(medicine.getExpiryDate());
            existing.setMrpIncludingGst(medicine.getMrpIncludingGst() > 0 
                ? medicine.getMrpIncludingGst() 
                : medicine.getPrice() + (medicine.getPrice() * medicine.getGstRate() / 100)
            );
            existing.setPurchaseRateExcludingGst(medicine.getPurchaseRateExcludingGst());
            return medicineRepository.save(existing);
        } else {
            // Save as a new medicine
            if (medicine.getMrpIncludingGst() == 0) {
                double purchaseRate = medicine.isPurchaseRateIncludesGst() 
                    ? medicine.getPrice() / (1 + medicine.getGstRate() / 100) 
                    : medicine.getPrice();
                double mrp = purchaseRate + (purchaseRate * medicine.getGstRate() / 100);
                medicine.setMrpIncludingGst(mrp);
            }
            return medicineRepository.save(medicine);
        }
    }
    
    public Medicine getMedicineByName(String name) {
        return medicineRepository.findByName(name).orElse(null);
    }
    

    public Medicine getMedicineById(Long medicineId) {
        Optional<Medicine> medicine = medicineRepository.findById(medicineId);
        return medicine.orElse(null);
    }

    public List<Medicine> getLowStockMedicines(int threshold) {
        return medicineRepository.findByStockLessThan(threshold);
    }

    public List<Medicine> getExpiredMedicines() {
        return medicineRepository.findByExpiryDateBefore(java.time.LocalDate.now());
    }
}
