package com.senla.dao;

import com.senla.api.dao.IMaintenanceDao;
import com.senla.api.filter.MaintenanceFilter;
import com.senla.comparator.maintenance.MaintenanceDateComparator;
import com.senla.comparator.maintenance.MaintenancePriceComparator;
import com.senla.filter.predicate.maintenance.MaintenanceFilterPredicate;
import com.senla.model.Maintenance;
import com.senla.util.IdGenerator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaintenanceDao implements IMaintenanceDao {
    private List<Maintenance> maintenances = new ArrayList<>();

    @Override
    public void save(Maintenance entity) {
        entity.setId(IdGenerator.generateMaintenanceId());
        maintenances.add(entity);
    }

    @Override
    public Maintenance getById(Long id) {
        for (Maintenance maintenance : maintenances) {
            if (id.equals(maintenance.getId())) {
                return maintenance;
            }
        }
        return null;
    }

    @Override
    public List<Maintenance> getAll() {
        return maintenances;
    }

    @Override
    public void delete(Maintenance entity) {
        maintenances.remove(getById(entity.getId()));
    }

    @Override
    public Maintenance update(Maintenance entity) {
        Maintenance maintenance = getById(entity.getId());
        maintenance.setName(entity.getName());
        maintenance.setPrice(entity.getPrice());
        return maintenance;
    }

    @Override
    public List<Maintenance> getAll(MaintenanceFilter filter) {
        return getAll(filter, null);
    }

    @Override
    public List<Maintenance> getAll(String sortName) {
        return getAll(null, sortName);
    }

    @Override
    public List<Maintenance> getAll(MaintenanceFilter filter, String sortName) {
        List<Maintenance> results = new ArrayList<>();
        Predicate<Maintenance> filterPredicate = getPredicateByFilter(filter);
        if (filterPredicate != null) {
            for (Maintenance entity : maintenances) {
                if (filterPredicate.test(entity)) {
                    results.add(entity);
                }
            }
        } else {
            results.addAll(maintenances);
        }
        Comparator<Maintenance> comparator = getComparatorBySortName(sortName);
        if (comparator != null) {
            results.sort(comparator);
        }
        return results;
    }

    private Comparator<Maintenance> getComparatorBySortName(String sortName) {
        if ("price".equals(sortName)) {
            return new MaintenancePriceComparator();
        }
        if ("date".equals(sortName)) {
            return new MaintenanceDateComparator();
        }
        return null;
    }

    private Predicate<Maintenance> getPredicateByFilter(MaintenanceFilter filter) {
        return new MaintenanceFilterPredicate(filter);
    }

}
