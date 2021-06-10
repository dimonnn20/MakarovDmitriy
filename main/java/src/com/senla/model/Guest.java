package com.senla.model;

import java.time.LocalDate;

public class Guest extends AEntity {

    private String name;
    private Integer age;
    private Long roomId;
    private LocalDate dateOfCheckOut;

    public Guest(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Long getRoomId() {
        return roomId;
    }

    public LocalDate getDateOfCheckOut() {
        return dateOfCheckOut;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public void setDateOfCheckOut(LocalDate dateOfCheckOut) {
        this.dateOfCheckOut = dateOfCheckOut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", room=" + roomId +
                ", date of check out =" + dateOfCheckOut +
                '}';
    }
}
