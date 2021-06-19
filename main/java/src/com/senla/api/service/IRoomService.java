package com.senla.api.service;

import com.senla.model.Room;
import com.senla.model.RoomStatus;

import java.time.LocalDate;
import java.util.List;

public interface IRoomService {


    public Room addRoom(Integer stars, Integer capacity, RoomStatus status, Double price);

    List<Room> getAll();

    Room getRoomById(Long id);

    List<Room> getAllRoomsOrderByStars();

    List<Room> getAllRoomsOrderByCapacity();

    List<Room> getAllRoomsOrderByPrice();

    List<Room> getFreeRoomsOrderByStars();

    List<Room> getFreeRoomsOrderByCapacity();

    List<Room> getFreeRoomsOrderByPrice();

    Integer getFreeRooms();

    List<Room> getFreeRoomsOnDate(LocalDate date);


}
