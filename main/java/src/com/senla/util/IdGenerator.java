package com.senla.util;

public class IdGenerator {

    private static Long guestId = 1L;
    private static Long roomId = 1L;
    private static Long maintenanceId = 1L;
    private static Long orderId = 1L;

    public static Long generateGuestId () {return guestId++;}
    public static Long generateRoomId () {return roomId++;}
    public static Long generateMaintenanceId () {return maintenanceId++;}
    public static Long generateOrderId () {return orderId++;}
}
