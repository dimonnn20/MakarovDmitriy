package com.senla.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order extends AEntity {
    private LocalDate dateOfCheckIn;
    private LocalDate dateOfCheckOut;
    private Guest guest;
    private Room room;
    private List<Maintenance> maintenances = new ArrayList<>();

    public Order(Guest guest, Room room, LocalDate dateOfCheckIn, LocalDate dateOfCheckOut) {
        this.guest = guest;
        this.room = room;
        this.dateOfCheckIn = dateOfCheckIn;
        this.dateOfCheckOut = dateOfCheckOut;
    }

    public Order(Guest guest, Room room, LocalDate dateOfCheckIn, LocalDate dateOfCheckOut, List<Maintenance> maintenances) {
        this.guest = guest;
        this.room = room;
        this.dateOfCheckIn = dateOfCheckIn;
        this.dateOfCheckOut = dateOfCheckOut;
        this.maintenances = maintenances;
    }

    public LocalDate getDateOfCheckIn() {
        return dateOfCheckIn;
    }

    public LocalDate getDateOfCheckOut() {
        return dateOfCheckOut;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setDateOfCheckIn(LocalDate dateOfCheckIn) {
        this.dateOfCheckIn = dateOfCheckIn;
    }

    public void setDateOfCheckOut(LocalDate dateOfCheckOut) {
        this.dateOfCheckOut = dateOfCheckOut;
    }

    public void setMaintenances(Maintenance maintenanceInOrder) {
        maintenances.add(maintenanceInOrder);
    }

    public List<Maintenance> getMaintenances() {
        return maintenances;
    }

    @Override
    public String toString() {
        return "Order{" +
                "dateOfCheckIn='" + dateOfCheckIn + '\'' +
                ", dateOfCheckOut='" + dateOfCheckOut + '\'' +
                ", guestOrderId=" + guest +
                ", roomOrderId=" + room +
                ", maintenanceOrder=" + maintenances +
                '}';
    }
}
