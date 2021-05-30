package com.senla.api.dao;

import com.senla.model.Guest;

import java.util.List;

public interface IGuestDao {
    void save (Guest entity);
    Guest getById (Long id);
    List<Guest> getAll();
    void delete (Guest entity);
    Guest update (Guest entity);
}
