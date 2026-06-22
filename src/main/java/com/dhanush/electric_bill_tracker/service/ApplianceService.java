package com.dhanush.electric_bill_tracker.service;

import com.dhanush.electric_bill_tracker.entity.Appliance;

import java.util.List;

public interface ApplianceService {

    Appliance saveAppliance(Appliance appliance);

    List<Appliance> getAllAppliances();

    Appliance getApplianceById(Long id);

    void deleteAppliance(Long id);

    double getTotalBill();
}