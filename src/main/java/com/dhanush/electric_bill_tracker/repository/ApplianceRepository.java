package com.dhanush.electric_bill_tracker.repository;

import com.dhanush.electric_bill_tracker.entity.Appliance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplianceRepository extends JpaRepository<Appliance, Long> {

}