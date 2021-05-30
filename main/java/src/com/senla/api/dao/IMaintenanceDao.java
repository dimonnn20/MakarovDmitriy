package com.senla.api.dao;

import com.senla.model.Maintenance;

import java.util.List;

public interface IMaintenanceDao {
    void save (Maintenance entity);
    Maintenance getById (Long id);
    List<Maintenance> getAll();
    void delete (Maintenance entity);
    Maintenance update (Maintenance entity);
}
