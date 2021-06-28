package com.senla.model;

public class Room extends AEntity {

    private Integer stars;
    private Integer capacity;
    private RoomStatus status;
    private Double price;

    public Room(Integer stars, Integer capacity, RoomStatus status, Double price) {
        this.stars = stars;
        this.capacity = capacity;
        this.status = status;
        this.price = price;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Room{" +
                "id=" + getId() +
                ", количество звезд =" + stars +
                ", capacity=" + capacity +
                ", status=" + status +
                ", price=" + price +
                '}';
    }
}
