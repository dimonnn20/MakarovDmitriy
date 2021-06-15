package com.senla.filter.predicate.order;

import com.senla.api.filter.OrderFilter;
import com.senla.model.Order;

import java.util.function.Predicate;

public class OrderFilterPredicate implements Predicate<Order> {
    private final OrderFilter orderFilter;

    public OrderFilterPredicate(OrderFilter orderFilter) {
        this.orderFilter = orderFilter;
    }

    @Override
    public boolean test(Order order) {
        if (orderFilter == null) {
            return true;
        }
        if (orderFilter.getTargetDate() != null) {
            if (orderFilter.getTargetDate().compareTo(order.getDateOfCheckIn()) < 0 ||
                    orderFilter.getTargetDate().compareTo(order.getDateOfCheckOut()) > 0) {
                return false;
            }
        }
        if (orderFilter.getTargetGuestId() != null) {
            if (!orderFilter.getTargetGuestId().equals(order.getGuest().getId())) {
                return false;
            }
        }
        if (orderFilter.getTargetRoomId() != null) {
            if (!orderFilter.getTargetRoomId().equals(order.getRoom().getId())) {
                return false;
            }
    }
        return true;
}}
