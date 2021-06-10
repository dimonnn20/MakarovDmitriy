package com.senla.api.dao;

import com.senla.api.filter.GuestFilter;
import com.senla.model.Guest;

import java.util.List;

public interface IGuestDao {
    void save(Guest entity);

    Guest getById(Long id);

    List<Guest> getAll();

    void delete(Guest entity);

    Guest update(Guest entity);

    List<Guest> getAll(GuestFilter filter);

    List<Guest> getAll(String sortName);

    List<Guest> getAll(GuestFilter filter, String sortName);
}
