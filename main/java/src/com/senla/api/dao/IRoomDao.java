package com.senla.api.dao;

import com.senla.model.Room;

import java.util.List;

public interface IRoomDao {
    void save (Room entity);
    Room getById (Long id);
    List <Room> getAll ();
    void delete (Room entity);
    Room update (Room entity);
}
