package com.senla.service;

import com.senla.api.dao.IGuestDao;
import com.senla.api.dao.IMaintenanceDao;
import com.senla.api.dao.IOrderDao;
import com.senla.api.dao.IRoomDao;
import com.senla.api.filter.OrderFilter;
import com.senla.api.service.IOrderService;
import com.senla.model.Maintenance;
import com.senla.model.Order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class OrderService implements IOrderService {
    private final IRoomDao roomDao;
    private final IGuestDao guestDao;
    private final IMaintenanceDao maintenanceDao;
    private final IOrderDao orderDao;

    public OrderService(IRoomDao roomDao, IGuestDao guestDao, IMaintenanceDao maintenanceDao, IOrderDao orderDao) {
        this.maintenanceDao = maintenanceDao;
        this.roomDao = roomDao;
        this.guestDao = guestDao;
        this.orderDao = orderDao;
    }

    @Override
    public Order addOrder(Long guestId, Long roomId, LocalDate dateOfCheckIn, LocalDate dateOfCheckOut) {
        Order order = new Order(guestDao.getById(guestId), roomDao.getById(roomId), dateOfCheckIn, dateOfCheckOut);
        orderDao.save(order);
        return order;
    }

    @Override
    public Maintenance addMaintenanceInOrder(Long maintenanceId, Long orderId, LocalDate date) {
        Maintenance maintenance = maintenanceDao.getById(maintenanceId);
        maintenance.setDate(date);
        orderDao.getById(orderId).setMaintenances(maintenance);
        return maintenance;
    }

    @Override
    public double getRoomFullCost(Long orderId) {
        double summ = 0D;
        if (orderDao.getById(orderId).getMaintenances() != null) {
            List<Maintenance> maintenanceInRoom = orderDao.getById(orderId).getMaintenances();
            for (Maintenance maintenance : maintenanceInRoom) {
                summ += maintenance.getPrice();
            }
        }
        return (DAYS.between(orderDao.getById(orderId).getDateOfCheckIn(), orderDao.getById(orderId).getDateOfCheckOut())) * orderDao.getById(orderId).getRoom().getPrice() + summ;
    }

    @Override
    public List<Order> getLastThreeGuestsOrder(Long id) {
        int i = 0;
        List<Order> lastThreeOrders = new ArrayList<>();
        for (Order order : orderDao.getAll("lastDate")) {
            if (order.getRoom().getId().equals(id) && i < 3) {
                lastThreeOrders.add(order);
                i++;
            }
        }
        return lastThreeOrders;
    }

    public List<Order> getOrdersByGuestId(Long id) {
        OrderFilter orderFilter = new OrderFilter();
        orderFilter.setTargetGuestId(id);
        List<Order> currentGuestOrders = orderDao.getAll(orderFilter);
        return currentGuestOrders;
    }


}