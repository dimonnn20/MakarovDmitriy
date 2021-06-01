package com.senla;

import com.senla.api.dao.IGuestDao;
import com.senla.api.dao.IMaintenanceDao;
import com.senla.api.dao.IOrderDao;
import com.senla.api.dao.IRoomDao;
import com.senla.api.service.IGuestService;
import com.senla.api.service.IMaintenanceService;
import com.senla.api.service.IOrderService;
import com.senla.api.service.IRoomService;
import com.senla.dao.GuestDao;
import com.senla.dao.MaintenanceDao;
import com.senla.dao.OrderDao;
import com.senla.dao.RoomDao;
import com.senla.model.*;
import com.senla.service.GuestService;
import com.senla.service.MaintenanceService;
import com.senla.service.OrderService;
import com.senla.service.RoomService;

public class Hotel {
    private static final IGuestDao guestDao = new GuestDao();
    private static final IGuestService guestService = new GuestService(guestDao);
    private static final IMaintenanceDao maintenanceDao = new MaintenanceDao();
    private static final IMaintenanceService maintenanceService = new MaintenanceService(maintenanceDao);
    private static final IRoomDao roomDao = new RoomDao();
    private static final IRoomService roomService = new RoomService(roomDao);
    private static final IOrderDao orderDao = new OrderDao();
    private static final IOrderService orderService = new OrderService(roomDao, guestDao,maintenanceDao,orderDao);



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

        Maintenance maintenance1 = maintenanceService.addMaintenance("SPA", 100D);
        Maintenance maintenance2 = maintenanceService.addMaintenance("Swimmingpool", 50D);
        Maintenance maintenance3 = maintenanceService.addMaintenance("Gym", 500D);
        Maintenance maintenance4 = maintenanceService.addMaintenance("Sauna", 600D);

        Order order = orderService.addOrder(1L,
                1L,
                "06-01-2021",
                "06-04-2021",
                null);
        orderService.addOrder(2L, 2L, "06-01-2021", "06-05-2021", null);
        System.out.println(orderDao.getAll());

    }
}
