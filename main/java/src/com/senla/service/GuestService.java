package com.senla.service;

import com.senla.api.dao.IGuestDao;
import com.senla.api.dao.IOrderDao;
import com.senla.api.filter.GuestFilter;
import com.senla.api.filter.OrderFilter;
import com.senla.api.service.IGuestService;
import com.senla.model.Guest;
import com.senla.model.Order;

import java.time.LocalDate;
import java.util.ArrayList;
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

    public List<Guest> getAllCurrentGuestsByDate() {
        List<Guest> currentGuests = new ArrayList<>();
        OrderFilter orderFilter = new OrderFilter();
        orderFilter.setTargetDate(LocalDate.now());
        List<Order> currentOrders = orderDao.getAll(orderFilter);

        for (Order order : currentOrders) {
            if (!currentGuests.contains(order.getGuestInOrder())) {
                Guest guest = order.getGuestInOrder();
                guest.setDateOfCheckOut(order.getDateOfCheckOut());
                guest.setRoomId(order.getRoomInOrder().getId());
                currentGuests.add(guest);
            }
        }
        GuestFilter guestFilter = new GuestFilter();
        guestFilter.setCurrentGuests(currentGuests);
        return guestDao.getAll(guestFilter, "date");
    }

    public List<Guest> getAllCurrentGuestsByAlphabet() {
        List<Guest> currentGuests = new ArrayList<>();
        OrderFilter orderFilter = new OrderFilter();
        orderFilter.setTargetDate(LocalDate.now());
        List<Order> currentOrders = orderDao.getAll(orderFilter);

        for (Order order : currentOrders) {
            if (!currentGuests.contains(order.getGuestInOrder())) {
                Guest guest = order.getGuestInOrder();
                guest.setDateOfCheckOut(order.getDateOfCheckOut());
                guest.setRoomId(order.getRoomInOrder().getId());
                currentGuests.add(guest);
            }
        }
        GuestFilter guestFilter = new GuestFilter();
        guestFilter.setCurrentGuests(currentGuests);
        return guestDao.getAll(guestFilter, "alphabet");
    }
}
