package com.senla.api.service;

import com.senla.model.Maintenance;

import java.util.List;

public interface IMaintenanceService {

    Maintenance addMaintenance(String name, Double price);

    List<Maintenance> getAllMaintenancesByPrice();

    List<Maintenance> getAllCurrentMaintenancesOrderByPrice(Long id);

    List<Maintenance> getAllCurrentMaintenancesOrderByDate(Long id);
}
