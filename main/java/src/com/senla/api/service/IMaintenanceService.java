package com.senla.api.service;

import com.senla.model.Maintenance;

public interface IMaintenanceService {

    public Maintenance addMaintenance(String name, Double price);
}
