package com.senla.comparator.order;

import com.senla.model.Order;

import java.util.Comparator;

public class OrderStartDateComparator implements Comparator<Order> {

    @Override
    public int compare(Order o1, Order o2) {
        return o1.getDateOfCheckIn().compareTo(o2.getDateOfCheckOut());
    }
}
