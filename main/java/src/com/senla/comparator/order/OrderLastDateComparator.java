package com.senla.comparator.order;

import com.senla.model.Order;

import java.util.Comparator;

public class OrderLastDateComparator implements Comparator<Order> {
    @Override
    public int compare(Order o1, Order o2) {
        return o2.getDateOfCheckOut().compareTo(o1.getDateOfCheckOut());
    }
}
