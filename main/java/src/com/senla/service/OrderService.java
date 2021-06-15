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
    public void addMaintenanceToOrder(Long maintenanceId, Long orderId, LocalDate date) {
        Order order = orderDao.getById(orderId);
        Maintenance maintenance = maintenanceDao.getById(maintenanceId);
        maintenance.setDate(date);
        order.getMaintenances().add(maintenance);
        orderDao.update(order);
    }

    @Override
    public double getRoomFullCost(Long orderId) {
        double summ = 0D;
        Order order = orderDao.getById(orderId);
        if (order != null) {
            List<Maintenance> maintenanceInOrder = order.getMaintenances();
            for (Maintenance maintenance : maintenanceInOrder) {
                summ += maintenance.getPrice();
            }
            return (DAYS.between(orderDao.getById(orderId).getDateOfCheckIn(), orderDao.getById(orderId).getDateOfCheckOut())) * orderDao.getById(orderId).getRoom().getPrice() + summ;
        }
      return 0D;
    }

    @Override
    public List<Order> getLastThreeGuestsOrdersByRoomId(Long id) {
        OrderFilter orderFilter = new OrderFilter();
        orderFilter.setTargetRoomId(id);
        int i = 0;
        List<Order> orders = orderDao.getAll(orderFilter,"lastDate");
        return orders.subList(0, 2);
    }

    public List<Order> getOrdersByGuestId(Long id) {
        OrderFilter orderFilter = new OrderFilter();
        orderFilter.setTargetGuestId(id);
        return orderDao.getAll(orderFilter);
    }

    @Override
    public List<Order> getAllCurrentGuestsOrderByDate() {
        return getAllCurrentGuestsOrderBy("lastDate");
    }

    @Override
    public List<Order> getAllCurrentGuestsOrderByGuestName() {
        return getAllCurrentGuestsOrderBy("name");
    }

    @Override
    private List<Order> getAllCurrentGuestsOrderBy(String sortName) {
        OrderFilter orderFilter = new OrderFilter();
        orderFilter.setTargetDate(LocalDate.now());
        return orderDao.getAll(orderFilter, sortName);
    }


}