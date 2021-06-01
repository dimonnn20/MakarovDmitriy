package com.senla.api.service;

import com.senla.model.Guest;
import com.senla.model.Room;
import com.senla.model.RoomStatus;

import java.util.List;

public interface IRoomService {


    public Room addRoom (Integer number, Integer capacity, RoomStatus status,Long price, List<Guest> guests);

}
