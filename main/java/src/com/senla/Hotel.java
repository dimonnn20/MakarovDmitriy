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

import java.time.LocalDate;
import java.util.List;

public class Hotel {
    private static final IGuestDao guestDao = new GuestDao();
    private static final IGuestService guestService = new GuestService(guestDao);
    private static final IMaintenanceDao maintenanceDao = new MaintenanceDao();
    private static final IMaintenanceService maintenanceService = new MaintenanceService(maintenanceDao);
    private static final IRoomDao roomDao = new RoomDao();
    private static final IOrderDao orderDao = new OrderDao();
    private static final IRoomService roomService = new RoomService(roomDao,orderDao);
    private static final IOrderService orderService = new OrderService(roomDao, guestDao,maintenanceDao,orderDao);


    public static void main(String[] args) {
        Guest guest1 = guestService.addGuest("Vasia", 19);
        Guest guest2 = guestService.addGuest("Igor", 30);
        Guest guest3 = guestService.addGuest("Sveta", 25);
        Guest guest4 = guestService.addGuest("Anton", 36);
        Guest guest5 = guestService.addGuest("Vladimir", 39);
        Guest guest6 = guestService.addGuest("Ksenia", 30);
        Guest guest7 = guestService.addGuest("Victoria", 30);
        Guest guest8 = guestService.addGuest("Sergey", 30);
        Guest guest9 = guestService.addGuest("Veronika", 30);
        Guest guest10 = guestService.addGuest("Anastasia", 30);

        Room room1 = roomService.addRoom(1, 2, RoomStatus.AVAILABLE, 100D);
        Room room2 = roomService.addRoom(2, 4, RoomStatus.AVAILABLE, 200D);
        Room room3 = roomService.addRoom(3, 1, RoomStatus.AVAILABLE, 300D);
        Room room4 = roomService.addRoom(4, 8, RoomStatus.AVAILABLE, 400D);

        Maintenance maintenance1 = maintenanceService.addMaintenance("SPA", 100D);
        Maintenance maintenance2 = maintenanceService.addMaintenance("Swimmingpool", 50D);
        Maintenance maintenance3 = maintenanceService.addMaintenance("Gym", 500D);
        Maintenance maintenance4 = maintenanceService.addMaintenance("Sauna", 600D);

        List<Room> allRooms= roomService.getAll();
        allRooms.forEach (System.out :: println);
        System.out.println("__________________________________________________________");
        System.out.println("Свободные комнаты (отсортированные по номеру) перед заказами");
        List <Room> freeRoomsOrderByNumber = roomService.getFreeRoomsOrderByNumber();
        freeRoomsOrderByNumber.forEach(System.out::println);
        System.out.println("__________________________________________________________");

        System.out.println("Свободные комнаты (отсортированные по вместимости) перед заказами");
        List <Room> freeRoomsByCapacity = roomService.getFreeRoomsOrderByCapacity();
        freeRoomsByCapacity.forEach(System.out::println);
        System.out.println("__________________________________________________________");

        Order order1 = orderService.addOrder(1L, 1L, LocalDate.of(2021, 05, 01),
                LocalDate.of(2021, 05, 10), null);

        Order order2 = orderService.addOrder(2L, 1L, LocalDate.of(2021, 05, 12),
                LocalDate.of(2021, 05, 16), null);

        Order order3 = orderService.addOrder(3L, 1L, LocalDate.of(2021, 05, 20),
                LocalDate.of(2021, 05, 25), null);

        Order order4 = orderService.addOrder(4L, 1L, LocalDate.of(2021, 06, 01),
                LocalDate.of(2021, 06, 03), null);

        Order order5 = orderService.addOrder(5L, 1L, LocalDate.of(2021, 06, 05),
                LocalDate.of(2021, 06, 10), null);

        System.out.println("Свободные комнаты (отсортированные по номеру) после 1 заказа");
        freeRoomsOrderByNumber = roomService.getFreeRoomsOrderByNumber();
        freeRoomsOrderByNumber.forEach(System.out::println);
        System.out.println("__________________________________________________________");

        System.out.println("Свободные комнаты (отсортированные по цене) после 1 заказа");
        List <Room> freeRoomsByPrice = roomService.getFreeRoomsOrderByPrice();
        freeRoomsByPrice.forEach(System.out::println);
        System.out.println("__________________________________________________________");

        Order order6 = orderService.addOrder(2L, 2L, LocalDate.of(2021, 06, 06), LocalDate.of(2021, 06, 14), null);

        System.out.println("Свободные комнаты (отсортированные по номеру) после 6 заказа");
        freeRoomsOrderByNumber = roomService.getFreeRoomsOrderByNumber();
        freeRoomsOrderByNumber.forEach(System.out::println);
        System.out.println("__________________________________________________________");

        Order order7 = orderService.addOrder(1L, 3L, LocalDate.of(2021, 06, 10), LocalDate.of(2021, 06, 14), null);
        System.out.println("Свободные комнаты (отсортированные по номеру) после 7 заказа");
        freeRoomsOrderByNumber = roomService.getFreeRoomsOrderByNumber();
        freeRoomsOrderByNumber.forEach(System.out::println);
        System.out.println("__________________________________________________________");

        System.out.println("Количество свободных номеров");
        System.out.println(roomService.getNumberFreeRoomsOrder());
        System.out.println("__________________________________________________________");

        System.out.println("Свободные номера на дату в будущем");
        List <Room> freeRoomsByDate = roomService.getFreeRoomsOrderByDate(LocalDate.of(2021, 07, 01));
        freeRoomsByDate.forEach(System.out::println);
        System.out.println("__________________________________________________________");

        System.out.println("Услуги по цене");
        List <Maintenance> maintenancesByPrice = maintenanceService.getMaintenanceByPrice();
        maintenancesByPrice.forEach(System.out::println);
        System.out.println("__________________________________________________________");

        System.out.println("Последних 3 заказа по ИД номера");
        List <Order> lastThreeOrders = orderService.getLastThreeGuestsOrder(1L);
        lastThreeOrders.forEach(System.out::println);
        System.out.println("__________________________________________________________");

    }
}
