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
    private final IGuestDao guestDao;

    public RoomService(IRoomDao roomDao, IGuestDao guestDao) {
        this.roomDao = roomDao;
        this.guestDao = guestDao;
    }
    @Override
    public Room addRoom(Integer number, Integer capacity, RoomStatus status,Long price, List<Guest> guestsInRoom) {
        Room room = new Room(number, capacity, status,price, guestsInRoom);
        room.setId(IdGenerator.generateRoomId());
        roomDao.save(room);
        return room;
    }

    @Override
    public void checkIn(Long guestId, Long roomId) {
        Boolean ifThereIsSuchGuestInRoom= false;
        if (guestDao.getById(guestId) == null) {
            System.out.println("Гость не найден");
        }
        if (roomDao.getById(roomId) == null) {
            System.out.println("Комната не найдена");
        } else {
            Room room = roomDao.getById(roomId);
            Guest guest = guestDao.getById(guestId);
            for (Guest guestInRoom: room.getGuests()) {
                if (guestInRoom.getId()==guestId) {
                ifThereIsSuchGuestInRoom = true;
            }}
            if (room.getCapacity()>room.getGuests().size() && ifThereIsSuchGuestInRoom==false) {
                room.getGuests().add(guest);
                } else {
                System.out.println("Номер переполнен или гость уже заселен");
            }
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