package com.senla.dao;

import com.senla.api.dao.IRoomDao;
import com.senla.api.filter.RoomFilter;
import com.senla.comparator.room.RoomCapacityComparator;
import com.senla.comparator.room.RoomStarsComparator;
import com.senla.comparator.room.RoomPriceComparator;
import com.senla.filter.predicate.room.RoomFilterPredicate;
import com.senla.model.Room;
import com.senla.util.IdGenerator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class RoomDao implements IRoomDao {

    private List<Room> rooms = new ArrayList<>();

    @Override
    public void save(Room entity) {
        entity.setId(IdGenerator.generateRoomId());
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
        return getAll(null, null);
    }

    @Override
    public void delete(Room entity) {
        rooms.remove(getById(entity.getId()));
    }

    @Override
    public Room update(Room entity) {
        Room room = getById(entity.getId());
        room.setStars(entity.getStars());
        room.setStatus(entity.getStatus());
        room.setCapacity(entity.getCapacity());
        room.setPrice(entity.getPrice());
        return room;
    }

    @Override
    public List<Room> getAll(RoomFilter filter) {

        return getAll(filter, null);
    }

    @Override
    public List<Room> getAll(String sortName) {
        return getAll(null, sortName);
    }

    @Override
    public List<Room> getAll(RoomFilter filter, String sortName) {
        List<Room> results = new ArrayList<>();

        Predicate<Room> filterPredicate = getPredicateByFilter(filter);
        if (filterPredicate != null) {
            for (Room entity : rooms) {
                if (filterPredicate.test(entity)) {
                    results.add(entity);
                }
            }
        } else {
            results.addAll(rooms);
        }

        Comparator<Room> comparator = getComparatorBySortName(sortName);
        if (comparator != null) {
            results.sort(comparator);
        }
        return results;
    }

    private Comparator<Room> getComparatorBySortName(String sortName) {
        if ("stars".equals(sortName)) {
            return new RoomStarsComparator();
        }
        if ("capacity".equals(sortName)) {
            return new RoomCapacityComparator();
        }
        if ("price".equals(sortName)) {
            return new RoomPriceComparator();
        }
        return null;
    }

    private Predicate<Room> getPredicateByFilter(RoomFilter filter) {
        return new RoomFilterPredicate(filter);
    }
}
