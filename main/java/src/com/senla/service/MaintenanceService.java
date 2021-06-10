package com.senla.service;

import com.senla.api.dao.IMaintenanceDao;
import com.senla.api.dao.IOrderDao;
import com.senla.api.filter.MaintenanceFilter;
import com.senla.api.service.IMaintenanceService;
import com.senla.model.Maintenance;
import com.senla.model.Order;

import java.util.ArrayList;
import java.util.List;

public class MaintenanceService implements IMaintenanceService {
    private final IMaintenanceDao maintenanceDao;
    private final IOrderDao orderDao;

    public MaintenanceService(IMaintenanceDao maintenanceDao, IOrderDao orderDao) {
        this.maintenanceDao = maintenanceDao;
        this.orderDao = orderDao;
    }


    @Override
    public Maintenance addMaintenance(String name, Double price) {
        Maintenance maintenance = new Maintenance(name, price);
        maintenanceDao.save(maintenance);
        return maintenance;
    }

    @Override
    public List<Maintenance> getAllMaintenancesByPrice() {
        return maintenanceDao.getAll("price");
    }


    public List<Maintenance> getAllCurrentMaintenancesByPrice(Long id) {
        List<Maintenance> currentMaintenance = new ArrayList<>();
        List<Order> currentOrders = orderDao.getAll();
        for (Order order : currentOrders) {
            if (order.getGuestInOrder().getId().equals(id) && order.getMaintenancesInOrder() != null) {
                for (Maintenance maintenance : order.getMaintenancesInOrder()) {
                    currentMaintenance.add(maintenance);
                }
            }
        }
        MaintenanceFilter maintenanceFilter = new MaintenanceFilter();
        maintenanceFilter.setCurrentMaintenance(currentMaintenance);

        return maintenanceDao.getAll(maintenanceFilter, "price");
    }

    public List<Maintenance> getAllCurrentMaintenancesByDate(Long id) {
        List<Maintenance> currentMaintenance = new ArrayList<>();
        List<Order> currentOrders = orderDao.getAll();
        for (Order order : currentOrders) {
            if (order.getGuestInOrder().getId().equals(id) && order.getMaintenancesInOrder() != null) {
                for (Maintenance maintenance : order.getMaintenancesInOrder()) {
                    currentMaintenance.add(maintenance);
                }
            }
        }
        MaintenanceFilter maintenanceFilter = new MaintenanceFilter();
        maintenanceFilter.setCurrentMaintenance(currentMaintenance);
        return maintenanceDao.getAll(maintenanceFilter, "date");
    }
}
