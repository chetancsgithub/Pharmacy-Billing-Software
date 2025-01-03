package com.pharmacy.pharmacy_billing.controller;



import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pharmacy.pharmacy_billing.model.Medicine;
import com.pharmacy.pharmacy_billing.service.MedicineService;

@Controller
public class AdminController {
    private final MedicineService medicineService;

    public AdminController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @GetMapping("/inventory")
    public String viewInventory(Model model) {
        List<Medicine> medicines = medicineService.getAllMedicines();
        model.addAttribute("medicines", medicines);
        return "inventory";
    }

    @GetMapping("/inventory/low-stock")
    public String viewLowStock(@RequestParam(defaultValue = "20") int threshold, Model model) {
        List<Medicine> lowStockMedicines = medicineService.getLowStockMedicines(threshold);
        model.addAttribute("lowStockMedicines", lowStockMedicines);
        return "low-stock";
    }

    @GetMapping("/inventory/expired")
    public String viewExpiredMedicines(Model model) {
        List<Medicine> expiredMedicines = medicineService.getExpiredMedicines();
        model.addAttribute("expiredMedicines", expiredMedicines);
        return "expired-medicines";
    }

    @PostMapping("/addMedicine")
    public String addMedicine(Medicine medicine) {
        medicineService.saveMedicine(medicine);
        return "redirect:/inventory";
    }

    
    
}

