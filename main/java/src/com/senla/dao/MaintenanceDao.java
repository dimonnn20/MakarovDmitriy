package com.senla.dao;

import com.senla.api.dao.IMaintenanceDao;
import com.senla.model.Maintenance;
import com.senla.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class MaintenanceDao implements IMaintenanceDao {
    private List <Maintenance> maintenances = new ArrayList<>();

    @Override
    public void save(Maintenance entity) {
        entity.setId(IdGenerator.generateMaintenanceId());
        maintenances.add(entity);
    }

    @Override
    public Maintenance getById(Long id) {
        for (Maintenance maintenance: maintenances) {
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
        for (Maintenance maintenance: maintenances) {
            if (maintenance.equals(entity)) {
                maintenances.remove(entity);
            }
        }
    }

    @Override
    public Maintenance update(Maintenance entity) {
        return null;
    }
}
