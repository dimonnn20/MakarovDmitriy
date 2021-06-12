package com.senla.service;

import com.senla.api.dao.IGuestDao;
import com.senla.api.dao.IOrderDao;
import com.senla.api.filter.OrderFilter;
import com.senla.api.service.IGuestService;
import com.senla.model.Guest;
import com.senla.model.Order;

import java.time.LocalDate;
import java.util.List;

public class GuestService implements IGuestService {
    private final IGuestDao guestDao;
    private final IOrderDao orderDao;

    public GuestService(IGuestDao guestDao, IOrderDao orderDao) {
        this.guestDao = guestDao;
        this.orderDao = orderDao;
    }

    @Override
    public Guest addGuest(String name, Integer age) {
        Guest guest = new Guest(name, age);
        guestDao.save(guest);
        return guest;
    }

    public List<Order> getAllCurrentGuestsBy(String sortName) {
        OrderFilter orderFilter = new OrderFilter();
        orderFilter.setTargetDate(LocalDate.now());
        return orderDao.getAll(orderFilter, sortName);
    }

    @Override
    public List<Order> getAllCurrentGuestsByDate() {
        return getAllCurrentGuestsBy("lastDate");
    }

    @Override
    public List<Order> getAllCurrentGuestsByAlphabet() {
        return getAllCurrentGuestsBy("name");
    }
}
