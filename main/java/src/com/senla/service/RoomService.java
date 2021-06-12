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
    public Room addRoom(Integer stars, Integer capacity, RoomStatus status, Double price) {
        Room room = new Room(stars, capacity, status, price);
        roomDao.save(room);
        return room;
    }

    @Override
    public Room getRoomById(Long id) {
        return roomDao.getById(id);
    }

    @Override
    public List<Room> getAll() {
        return roomDao.getAll();
    }

    @Override
    public List<Room> getAllRoomsByStars() {
        return roomDao.getAll("stars");
    }

    @Override
    public List<Room> getAllRoomsByCapacity() {
        return roomDao.getAll("capacity");
    }

    @Override
    public List<Room> getAllRoomsByPrice() {
        return roomDao.getAll("price");
    }

    private List<Room> getFreeRoomsOrderBy(String sortName) {
        OrderFilter orderFilter = new OrderFilter();
        orderFilter.setTargetDate(LocalDate.now());
        List<Order> currentOrders = orderDao.getAll(orderFilter);
        List<Room> notFreeRooms = new ArrayList<>();
        for (Order order : currentOrders) {
            notFreeRooms.add(order.getRoom());
        }
        RoomFilter roomFilter = new RoomFilter();
        roomFilter.setExcludedRooms(notFreeRooms);
        return roomDao.getAll(roomFilter, sortName);
    }

    @Override
    public List<Room> getFreeRoomsOrderByStars() {
        return getFreeRoomsOrderBy("stars");
    }

    @Override
    public List<Room> getFreeRoomsOrderByCapacity() {
        return getFreeRoomsOrderBy("capacity");
    }

    @Override
    public List<Room> getFreeRoomsOrderByPrice() {
        return getFreeRoomsOrderBy("price");
    }

    @Override
    public Integer getNumberFreeRoomsOrder() {
        return getFreeRoomsOrderBy(null).size();
    }

    @Override
    public List<Room> getFreeRoomsOrderByDate(LocalDate date) {
        OrderFilter orderFilter = new OrderFilter();
        orderFilter.setTargetDate(date);
        List<Order> currentOrders = orderDao.getAll(orderFilter);
        List<Room> notFreeRooms = new ArrayList<>();
        for (Order order : currentOrders) {
            notFreeRooms.add(order.getRoom());
        }

        RoomFilter roomFilter = new RoomFilter();
        roomFilter.setExcludedRooms(notFreeRooms);
        return roomDao.getAll(roomFilter);
    }

}