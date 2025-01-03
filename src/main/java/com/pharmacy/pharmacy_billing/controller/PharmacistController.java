package com.pharmacy.pharmacy_billing.controller;



import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pharmacy.pharmacy_billing.model.Medicine;
import com.pharmacy.pharmacy_billing.model.Transaction;
import com.pharmacy.pharmacy_billing.service.MedicineService;
import com.pharmacy.pharmacy_billing.service.TransactionService;

@Controller
public class PharmacistController {
    private final MedicineService medicineService;
    private final TransactionService transactionService;

    public PharmacistController(MedicineService medicineService, TransactionService transactionService) {
        this.medicineService = medicineService;
        this.transactionService = transactionService;
    }

    
    @GetMapping("/pharmacist/dashboard")
    public String pharmacistDashboard(Model model) {
        List<Medicine> medicines = medicineService.getAllMedicines();
        model.addAttribute("medicines", medicines);
        return "billing";
    }

    @PostMapping("/pharmacist/sellMedicine")
    public String sellMedicine(@RequestParam Long medicineId, @RequestParam int quantity, @RequestParam String customerName) {
        Medicine medicine = medicineService.getMedicineById(medicineId);
        if (medicine != null && medicine.getQuantity() >= quantity) {
            medicine.setQuantity(medicine.getQuantity() - quantity);
            medicineService.saveMedicine(medicine);

            Transaction transaction = new Transaction();
            transaction.setCustomerName(customerName);
            transaction.setMedicineDetails(medicine.getName() + " x " + quantity);
            transaction.setTotalAmount(quantity * medicine.getPrice());
            transaction.setDate(java.time.LocalDate.now().toString());
            transactionService.saveTransaction(transaction);
        }
        return "redirect:/pharmacist/dashboard";
    }
    
    @GetMapping("/pharmacist/findMedicineId")
    public String findMedicineId(@RequestParam String name, Model model) {
        Medicine medicine = medicineService.getMedicineByName(name);
        if (medicine != null) {
            model.addAttribute("medicineId", medicine.getId());
        } else {
            model.addAttribute("error", "Medicine not found");
        }
        return "billing";
    }

}