package com.senla.api.dao;

import com.senla.api.filter.MaintenanceFilter;
import com.senla.model.Maintenance;

import java.util.List;

public interface IMaintenanceDao {

    void save(Maintenance entity);

    Maintenance getById(Long id);

    List<Maintenance> getByIds(List<Long> maintenanceInOrderId);

    List<Maintenance> getAll();

    void delete(Maintenance entity);

    Maintenance update(Maintenance entity);

    List<Maintenance> getAll(MaintenanceFilter filter);

    List<Maintenance> getAll(String sortName);

    List<Maintenance> getAll(MaintenanceFilter filter, String sortName);
}
