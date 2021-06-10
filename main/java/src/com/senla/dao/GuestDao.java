package com.senla.dao;

import com.senla.api.dao.IGuestDao;
import com.senla.api.filter.GuestFilter;
import com.senla.comparator.guest.GuestAlphabetComparator;
import com.senla.comparator.guest.GuestDateComparator;
import com.senla.filter.predicate.guest.GuestFilterPredicate;
import com.senla.model.Guest;
import com.senla.util.IdGenerator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class GuestDao implements IGuestDao {

    private List<Guest> guests = new ArrayList<>();

    @Override
    public void save(Guest entity) {
        entity.setId(IdGenerator.generateGuestId());
        guests.add(entity);
    }

    @Override
    public Guest getById(Long id) {
        for (Guest guest : guests) {
            if (id.equals(guest.getId())) {
                return guest;
            }
        }
        return null;
    }

    @Override
    public List<Guest> getAll() {
        return getAll(null, null);
    }

    @Override
    public void delete(Guest entity) {
        guests.remove(getById(entity.getId()));
    }

    @Override
    public Guest update(Guest entity) {
        getById(entity.getId()).setAge(entity.getAge());
        getById(entity.getId()).setName(entity.getName());
        getById(entity.getId()).setRoomId(entity.getRoomId());
        getById(entity.getId()).setDateOfCheckOut(entity.getDateOfCheckOut());
        return getById(entity.getId());
    }

    @Override
    public List<Guest> getAll(GuestFilter filter) {
        return getAll(filter, null);
    }

    @Override
    public List<Guest> getAll(String sortName) {
        return getAll(null, sortName);
    }

    @Override
    public List<Guest> getAll(GuestFilter filter, String sortName) {
        List<Guest> results = new ArrayList<>();

        Predicate<Guest> filterPredicate = getPredicateByFilter(filter);
        if (filterPredicate != null) {
            for (Guest entity : guests) {
                if (filterPredicate.test(entity)) {
                    results.add(entity);
                }
            }
        } else {
            results.addAll(guests);
        }
        Comparator<Guest> comparator = getComparatorBySortName(sortName);
        if (comparator != null) {
            results.sort(comparator);
        }
        return results;
    }

    private Comparator<Guest> getComparatorBySortName(String sortName) {
        if ("alphabet".equals(sortName)) {
            return new GuestAlphabetComparator();
        }
        if ("date".equals(sortName)) {
            return new GuestDateComparator();
        }
        return null;
    }

    private Predicate<Guest> getPredicateByFilter(GuestFilter filter) {
        return new GuestFilterPredicate(filter);
    }
}
