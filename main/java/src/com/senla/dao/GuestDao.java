package com.senla.dao;

import com.senla.api.dao.IGuestDao;
import com.senla.model.Guest;

import java.util.ArrayList;
import java.util.List;

public class GuestDao implements IGuestDao {

private List <Guest> guests = new ArrayList<>();
    @Override
    public void save(Guest entity) {
    guests.add(entity);
    }

    @Override
    public Guest getById(Long id) {
        for (Guest guest: guests) {
            if (id.equals(guest.getId())) {
                return guest;
            }
        }
        return null;
    }

    @Override
    public List<Guest> getAll() {
        return guests;
    }

    @Override
    public void delete(Guest entity) {
                guests.remove(entity);
    }

    @Override
    public Guest update(Guest entity) {
        return null;
    }
}
