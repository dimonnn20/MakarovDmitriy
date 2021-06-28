package com.senla.filter.predicate.room;

import com.senla.api.filter.RoomFilter;
import com.senla.model.Room;

import java.util.function.Predicate;

public class RoomFilterPredicate implements Predicate<Room> {
    private final RoomFilter roomFilter;

    public RoomFilterPredicate(RoomFilter roomFilter) {
        this.roomFilter = roomFilter;
    }


    @Override
    public boolean test(Room room) {
        if (roomFilter == null) {
            return true;
        }
        if (roomFilter.getExcludedRooms() != null) {
            if (roomFilter.getExcludedRooms().contains(room)) {
                return false;
            }
        }
        if (roomFilter.getMinCapacity() != null) {
            if (roomFilter.getMinCapacity() > room.getCapacity()) {
                return false;
            }
        }
        return true;
    }
}
