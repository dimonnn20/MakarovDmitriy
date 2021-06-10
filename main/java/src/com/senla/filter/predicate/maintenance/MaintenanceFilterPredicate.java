package com.senla.filter.predicate.maintenance;

import com.senla.api.filter.MaintenanceFilter;
import com.senla.model.Maintenance;

import java.util.function.Predicate;

public class MaintenanceFilterPredicate implements Predicate<Maintenance> {
    private final MaintenanceFilter maintenanceFilter;

    public MaintenanceFilterPredicate(MaintenanceFilter maintenanceFilter) {
        this.maintenanceFilter = maintenanceFilter;
    }

    @Override
    public boolean test(Maintenance maintenance) {
        if (maintenanceFilter == null) {
            return true;
        }
        if (maintenanceFilter.getCurrentMaintenance() != null) {
            if (!maintenanceFilter.getCurrentMaintenance().contains(maintenance)) {
                return false;
            }
        }
        return true;
    }
}
