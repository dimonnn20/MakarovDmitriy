package com.senla.api.filter;

import com.senla.model.Room;

import java.util.List;

public class RoomFilter {

    private List<Room> excludedRooms;

    private Integer minCapacity;

    public List<Room> getExcludedRooms() {
        return excludedRooms;
    }

    public void setExcludedRooms(List<Room> excludedRooms) {
        this.excludedRooms = excludedRooms;
    }

    public Integer getMinCapacity() {
        return minCapacity;
    }

    public void setMinCapacity(Integer minCapacity) {
        this.minCapacity = minCapacity;
    }
}
