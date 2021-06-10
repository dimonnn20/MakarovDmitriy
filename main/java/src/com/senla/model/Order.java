package com.senla.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order extends AEntity {
    private LocalDate dateOfCheckIn;
    private LocalDate dateOfCheckOut;
    private Guest guestInOrder;
    private Room roomInOrder;
    private List<Maintenance> maintenancesInOrder = new ArrayList<>();

    public Order(Guest guestInOrder, Room roomInOrder, LocalDate dateOfCheckIn, LocalDate dateOfCheckOut) {
        this.guestInOrder = guestInOrder;
        this.roomInOrder = roomInOrder;
        this.dateOfCheckIn = dateOfCheckIn;
        this.dateOfCheckOut = dateOfCheckOut;
    }

    public Order(Guest guestInOrder, Room roomInOrder, LocalDate dateOfCheckIn, LocalDate dateOfCheckOut, List<Maintenance> maintenancesInOrder) {
        this.guestInOrder = guestInOrder;
        this.roomInOrder = roomInOrder;
        this.dateOfCheckIn = dateOfCheckIn;
        this.dateOfCheckOut = dateOfCheckOut;
        this.maintenancesInOrder = maintenancesInOrder;
    }

    public LocalDate getDateOfCheckIn() {
        return dateOfCheckIn;
    }

    public LocalDate getDateOfCheckOut() {
        return dateOfCheckOut;
    }

    public Guest getGuestInOrder() {
        return guestInOrder;
    }

    public Room getRoomInOrder() {
        return roomInOrder;
    }

    public void setDateOfCheckIn(LocalDate dateOfCheckIn) {
        this.dateOfCheckIn = dateOfCheckIn;
    }

    public void setDateOfCheckOut(LocalDate dateOfCheckOut) {
        this.dateOfCheckOut = dateOfCheckOut;
    }

    public void setMaintenancesInOrder(Maintenance maintenanceInOrder) {
        maintenancesInOrder.add(maintenanceInOrder);
    }

    public List<Maintenance> getMaintenancesInOrder() {
        return maintenancesInOrder;
    }

    @Override
    public String toString() {
        return "Order{" +
                "dateOfCheckIn='" + dateOfCheckIn + '\'' +
                ", dateOfCheckOut='" + dateOfCheckOut + '\'' +
                ", guestOrderId=" + guestInOrder +
                ", roomOrderId=" + roomInOrder +
                ", maintenanceOrder=" + maintenancesInOrder +
                '}';
    }
}
