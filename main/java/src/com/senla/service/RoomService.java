package com.senla.service;

import com.senla.api.dao.IOrderDao;
import com.senla.api.dao.IRoomDao;
import com.senla.api.filter.OrderFilter;
import com.senla.api.filter.RoomFilter;
import com.senla.api.service.IRoomService;
import com.senla.model.Order;
import com.senla.model.Room;
import com.senla.model.RoomStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RoomService implements IRoomService {
    private final IRoomDao roomDao;
    private final IOrderDao orderDao;

    public RoomService(IRoomDao roomDao, IOrderDao orderDao) {
        this.roomDao = roomDao;
        this.orderDao = orderDao;
    }

    @Override
    public Room addRoom(Integer number, Integer capacity, RoomStatus status, Double price) {
        Room room = new Room(number, capacity, status, price);
        roomDao.save(room);
        return room;
    }

    @Override
    public List<Room> getAll() {
        return roomDao.getAll();
    }

    @Override
    public List<Room> getFreeRoomsOrderByNumber() {
        OrderFilter orderFilter = new OrderFilter();
        orderFilter.setTargetDate(LocalDate.now());
        List <Order> currentOrders = orderDao.getAll(orderFilter);
        List <Room> notFreeRooms = new ArrayList<>();
        for (Order order : currentOrders) {
            notFreeRooms.add(order.getRoomInOrder());
        }
        RoomFilter roomFilter = new RoomFilter();
        roomFilter.setExcludedRooms(notFreeRooms);
        return roomDao.getAll(roomFilter,"number");
    }

    @Override
    public List<Room> getFreeRoomsOrderByCapacity() {
        OrderFilter orderFilter = new OrderFilter();
        orderFilter.setTargetDate(LocalDate.now());
        List <Order> currentOrders = orderDao.getAll(orderFilter);
        List <Room> notFreeRooms = new ArrayList<>();
        for (Order order: currentOrders) {
            notFreeRooms.add(order.getRoomInOrder());
        }
        RoomFilter roomFilter = new RoomFilter();
        roomFilter.setExcludedRooms(notFreeRooms);
        return roomDao.getAll(roomFilter,"capacity");
    }

    @Override
    public List<Room> getFreeRoomsOrderByPrice() {
        OrderFilter orderFilter = new OrderFilter();
        orderFilter.setTargetDate(LocalDate.now());
        List <Order> currentOrders = orderDao.getAll(orderFilter);
        List <Room> notFreeRooms = new ArrayList<>();
        for (Order order: currentOrders) {
            notFreeRooms.add(order.getRoomInOrder());

        }
        RoomFilter roomFilter = new RoomFilter();
        roomFilter.setExcludedRooms(notFreeRooms);
        return roomDao.getAll(roomFilter,"price");
    }

    @Override
    public Integer getNumberFreeRoomsOrder() {
        OrderFilter orderFilter = new OrderFilter();
        orderFilter.setTargetDate(LocalDate.now());
        List <Order> currentOrders = orderDao.getAll(orderFilter);
        List <Room> notFreeRooms = new ArrayList<>();
        for (Order order: currentOrders) {
            notFreeRooms.add(order.getRoomInOrder());
        }
        RoomFilter roomFilter = new RoomFilter();
        roomFilter.setExcludedRooms(notFreeRooms);
        return roomDao.getAll(roomFilter,null).size();
    }

    @Override
    public List<Room> getFreeRoomsOrderByDate(LocalDate date) {
        OrderFilter orderFilter = new OrderFilter();
        orderFilter.setTargetDate(date);
        List <Order> currentOrders = orderDao.getAll(orderFilter);
        List <Room> notFreeRooms = new ArrayList<>();
        for (Order order: currentOrders) {
            notFreeRooms.add(order.getRoomInOrder());
        }

        RoomFilter roomFilter = new RoomFilter();
        roomFilter.setExcludedRooms(notFreeRooms);
        return roomDao.getAll(roomFilter,null);
    }

}