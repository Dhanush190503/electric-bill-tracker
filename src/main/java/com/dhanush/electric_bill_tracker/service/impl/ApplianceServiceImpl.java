package com.dhanush.electric_bill_tracker.service.impl;

import com.dhanush.electric_bill_tracker.entity.Appliance;
import com.dhanush.electric_bill_tracker.repository.ApplianceRepository;
import com.dhanush.electric_bill_tracker.service.ApplianceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplianceServiceImpl implements ApplianceService {

    private final ApplianceRepository repository;

    public ApplianceServiceImpl(ApplianceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Appliance saveAppliance(Appliance appliance) {

        double unitsConsumed =
                (appliance.getWatts()
                        * appliance.getRunningHours()
                        * appliance.getDaysUsed())
                        / 1000;

        double totalCost =
                unitsConsumed * appliance.getCostPerUnit();

        appliance.setUnitsConsumed(unitsConsumed);
        appliance.setTotalCost(totalCost);

        return repository.save(appliance);
    }

    @Override
    public List<Appliance> getAllAppliances() {
        return repository.findAll();
    }

    @Override
    public Appliance getApplianceById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Appliance not found with id: " + id));
    }

    @Override
    public void deleteAppliance(Long id) {

        repository.deleteById(id);
    }

    @Override
    public double getTotalBill() {

        return repository.findAll()
                .stream()
                .mapToDouble(Appliance::getTotalCost)
                .sum();
    }
}