package com.senla.api.service;

import com.senla.model.Room;
import com.senla.model.RoomStatus;

import java.time.LocalDate;
import java.util.List;

public interface IRoomService {


    public Room addRoom(Integer stars, Integer capacity, RoomStatus status, Double price);

    List<Room> getAll();

    Room getRoomById(Long id);

    List<Room> getAllRoomsByStars();

    List<Room> getAllRoomsByCapacity();

    List<Room> getAllRoomsByPrice();

    List<Room> getFreeRoomsOnDateByStars();

    List<Room> getFreeRoomsOnDateByCapacity();

    List<Room> getFreeRoomsOnDateByPrice();

    Integer getFreeRoomsOnDate();

    List<Room> getFreeRoomsOnDate(LocalDate date);


}
