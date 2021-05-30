package com.senla.model;

public class Maintenance extends AEntity {
    private String name;
    private Double price;
    public  String getName () {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice () {
        return price;
    }
    public void setPrice (Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Maintenance{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
