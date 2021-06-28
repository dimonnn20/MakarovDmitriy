package com.senla.comparator.maintenance;

import com.senla.model.Maintenance;

import java.util.Comparator;

public class MaintenancePriceComparator implements Comparator<Maintenance> {
    @Override
    public int compare(Maintenance o1, Maintenance o2) {
        return o1.getPrice().compareTo(o2.getPrice());
    }
}
