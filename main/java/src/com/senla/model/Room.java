package com.senla.model;

import java.util.ArrayList;
import java.util.List;

public class Room extends AEntity {

    private Integer number;
    private Integer capacity;
    private RoomStatus status;
    private Long price;
    private List <Guest> guestsInRoom;

    public Room (Integer number,Integer capacity, RoomStatus status,Long price, List<Guest> guestsInRoom) {
        this.number = number;
        this.capacity = capacity;
        this.status = status;
        this.price = price;
        this.guestsInRoom = guestsInRoom;

    }

    public Integer getNumber () {return number;}
    public void setNumber (Integer number) {this.number = number;}
    public Integer getCapacity () {return capacity;}
    public void setCapacity (Integer capacity) {this.capacity = capacity;}
    public RoomStatus getStatus() {return status;}
    public void setStatus (RoomStatus status) {this.status=status;}
    public Long getPrice() {return price;}
    public void setPrice (Long price) {this.price=price;}

    public List<Guest> getGuests () {
        if (guestsInRoom ==null) {
            guestsInRoom = new ArrayList<>();
        }
        return guestsInRoom;
    }

    @Override
    public String toString() {
        return "Room{" +
                "number=" + number +
                ", capacity=" + capacity +
                ", status=" + status +
                ", price=" + price +
                ", guestsInRoom=" + guestsInRoom +
                '}';
    }
}
