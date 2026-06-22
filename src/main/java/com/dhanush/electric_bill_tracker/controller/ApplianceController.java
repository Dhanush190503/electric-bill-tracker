package com.dhanush.electric_bill_tracker.controller;

import com.dhanush.electric_bill_tracker.entity.Appliance;
import com.dhanush.electric_bill_tracker.service.ApplianceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appliances")
@CrossOrigin("*")
public class ApplianceController {

    private final ApplianceService applianceService;

    public ApplianceController(ApplianceService applianceService) {
        this.applianceService = applianceService;
    }

    @PostMapping
    public Appliance saveAppliance(
            @RequestBody Appliance appliance) {

        return applianceService.saveAppliance(appliance);
    }

    @GetMapping
    public List<Appliance> getAllAppliances() {

        return applianceService.getAllAppliances();
    }

    @GetMapping("/{id}")
    public Appliance getApplianceById(
            @PathVariable Long id) {

        return applianceService.getApplianceById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteAppliance(
            @PathVariable Long id) {

        applianceService.deleteAppliance(id);

        return "Appliance Deleted Successfully";
    }

    @GetMapping("/total")
    public double getTotalBill() {

        return applianceService.getTotalBill();
    }
}