package com.senla.service;

import com.senla.api.dao.IMaintenanceDao;
import com.senla.api.dao.IOrderDao;
import com.senla.api.filter.OrderFilter;
import com.senla.api.service.IMaintenanceService;
import com.senla.comparator.maintenance.MaintenanceDateComparator;
import com.senla.comparator.maintenance.MaintenancePriceComparator;
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


    private List<Maintenance> getAllCurrentMaintenancesOrderBy(Long id) {
        List<Maintenance> currentMaintenance = new ArrayList<>();
        OrderFilter orderFilter = new OrderFilter();
        orderFilter.setTargetGuestId(id);
        List<Order> currentGuestOrders = orderDao.getAll(orderFilter);
        for (Order order : currentGuestOrders) {
            currentMaintenance.addAll(order.getMaintenances());
        }
        return currentMaintenance;
    }

    public List<Maintenance> getAllCurrentMaintenancesOrderByPrice(Long id) {
        MaintenancePriceComparator maintenancePriceComparator = new MaintenancePriceComparator();
        List<Maintenance> currentMaintenance = new ArrayList<>();
        currentMaintenance.addAll(getAllCurrentMaintenancesOrderBy(id));
        currentMaintenance.sort(maintenancePriceComparator);
        return currentMaintenance;
    }


    public List<Maintenance> getAllCurrentMaintenancesOrderByDate(Long id) {
        MaintenanceDateComparator maintenanceDateComparator = new MaintenanceDateComparator();
        List<Maintenance> currentMaintenance = new ArrayList<>();
        currentMaintenance.addAll(getAllCurrentMaintenancesOrderBy(id));
        currentMaintenance.sort(maintenanceDateComparator);
        return currentMaintenance;
    }
}
