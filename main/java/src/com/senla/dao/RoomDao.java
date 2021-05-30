package com.senla.dao;

import com.senla.api.dao.IRoomDao;
import com.senla.model.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomDao implements IRoomDao {

    private List <Room> rooms = new ArrayList<>();
    @Override
    public void save(Room entity) {
    rooms.add(entity);
    }

    @Override
    public Room getById(Long id) {
        for (Room entity : rooms)
            if (entity.getId().equals(id)) {
                return entity;
            }
        return null;
    }

    @Override
    public List<Room> getAll() {
        return rooms;
    }

    @Override
    public void delete(Room entity) {

    }

    @Override
    public Room update(Room entity) {
        return null;
    }

}
