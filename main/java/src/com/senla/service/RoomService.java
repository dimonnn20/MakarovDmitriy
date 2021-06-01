package com.senla.service;

import com.senla.api.dao.IGuestDao;
import com.senla.api.dao.IRoomDao;
import com.senla.api.service.IRoomService;
import com.senla.model.Guest;
import com.senla.model.Room;
import com.senla.model.RoomStatus;
import com.senla.util.IdGenerator;

import java.util.List;

public class RoomService implements IRoomService {
    private final IRoomDao roomDao;

    public RoomService(IRoomDao roomDao) {
        this.roomDao = roomDao;
    }
    @Override
    public Room addRoom(Integer number, Integer capacity, RoomStatus status,Long price, List<Guest> guestsInRoom) {
        Room room = new Room(number, capacity, status,price, guestsInRoom);
        roomDao.save(room);
        return room;
    }


}