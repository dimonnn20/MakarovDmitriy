package com.senla.api.filter;

import com.senla.model.Maintenance;

import java.util.List;

public class MaintenanceFilter {

    private List<Maintenance> currentMaintenance;

    public List<Maintenance> getCurrentMaintenance() {
        return currentMaintenance;
    }

    public void setCurrentMaintenance(List<Maintenance> currentMaintenance) {
        this.currentMaintenance = currentMaintenance;
    }
}
