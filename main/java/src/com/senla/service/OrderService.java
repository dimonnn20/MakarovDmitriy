package com.senla.service;

import com.senla.api.dao.IGuestDao;
import com.senla.api.dao.IMaintenanceDao;
import com.senla.api.dao.IOrderDao;
import com.senla.api.dao.IRoomDao;
import com.senla.api.service.IOrderService;
import com.senla.model.Guest;
import com.senla.model.Maintenance;
import com.senla.model.Order;
import com.senla.model.Room;
import com.senla.util.DaysOfStayCalculations;

import java.util.List;

public class OrderService implements IOrderService {
    private final IRoomDao roomDao;
    private final IGuestDao guestDao;
    private final IMaintenanceDao maintenanceDao;
    private final IOrderDao orderDao;


    public  OrderService (IRoomDao roomDao, IGuestDao guestDao, IMaintenanceDao maintenanceDao, IOrderDao orderDao) {
        this.maintenanceDao = maintenanceDao;
        this.roomDao = roomDao;
        this.guestDao = guestDao;
        this.orderDao = orderDao;
    }
    @Override
    public Order addOrder (Long guestOrderId, Long roomOrderId, String dateOfCheckIn, String dateOfCheckOut,
                           List <Maintenance> maintenanceOrder) {
        Order order = new Order(guestOrderId, roomOrderId, dateOfCheckIn, dateOfCheckOut, maintenanceOrder);
        checkIn(guestOrderId,roomOrderId);
        orderDao.save(order);
        return order;
    }
    private void checkIn(Long guestOrderId, Long roomOrderId) {
            Room room = roomDao.getById(roomOrderId);
            Guest guest = guestDao.getById(guestOrderId);
            if (room.getCapacity()>room.getGuests().size()) {
                room.getGuests().add(guest);
            }
        }

    @Override
    public void evictGuest(Long guestId) {
        Guest guestForEvict = guestDao.getById(guestId);
        for (Room room : roomDao.getAll()) {
            room.getGuests().remove(guestForEvict);
        }
    }
}
