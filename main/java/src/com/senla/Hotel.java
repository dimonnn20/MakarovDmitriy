package com.senla;

import com.senla.api.dao.IGuestDao;
import com.senla.api.dao.IRoomDao;
import com.senla.api.service.IGuestService;
import com.senla.api.service.IRoomService;
import com.senla.dao.GuestDao;
import com.senla.dao.RoomDao;
import com.senla.model.Guest;
import com.senla.model.Room;
import com.senla.model.RoomStatus;
import com.senla.service.GuestService;
import com.senla.service.RoomService;

public class Hotel {
    private static final IGuestDao guestDao = new GuestDao();
    private static final IGuestService guestService = new GuestService(guestDao);

    private static final IRoomDao roomDao = new RoomDao();
    private static final IRoomService roomService = new RoomService(roomDao, guestDao);

    public static void main(String[] args) {
        Guest guest1 = guestService.addGuest("Vasia", 19);
        Guest guest2 = guestService.addGuest("Igor", 30);
        Guest guest3 = guestService.addGuest("Sveta", 30);
        Guest guest4 = guestService.addGuest("Anton", 30);
        Guest guest5 = guestService.addGuest("Vladimir", 30);
        Guest guest6 = guestService.addGuest("Ksenia", 30);
        Guest guest7 = guestService.addGuest("Victoria", 30);
        Guest guest8 = guestService.addGuest("Sergey", 30);
        Guest guest9 = guestService.addGuest("Veronika", 30);
        Guest guest10 = guestService.addGuest("Anastasia", 30);

        Room room1 = roomService.addRoom(1, 2, RoomStatus.OPEN,300L,null);
        Room room2 = roomService.addRoom(1, 4, RoomStatus.OPEN,400L,null);
        Room room3 = roomService.addRoom(1, 1, RoomStatus.OPEN,200L,null);
        Room room4 = roomService.addRoom(1, 8, RoomStatus.OPEN,800L,null);

        roomService.checkIn(1L, 4L);
        roomService.checkIn(2L, 4L);
        roomService.checkIn(3L, 4L);
        roomService.checkIn(4L, 4L);
        roomService.checkIn(5L, 4L);
        roomService.checkIn(6L, 4L);
        roomService.checkIn(7L, 4L);
        roomService.checkIn(1L, 4L);
        roomService.checkIn(8L, 4L);
        //roomService.checkIn(9L, 4L);
        //roomService.checkIn(10L, 4L);
       System.out.println(room1.getGuests());
       roomService.evictGuest(1L);
       System.out.println(room1.getGuests());
        System.out.println(roomDao.getAll());

    }
}
