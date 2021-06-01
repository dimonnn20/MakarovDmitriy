package com.senla.api.service;

import com.senla.model.Maintenance;
import com.senla.model.Order;

import java.util.List;

public interface IOrderService {
    public void evictGuest (Long guestId);
    public Order addOrder(Long guestOrderId, Long roomOrderId, String dateOfCheckIn, String dateOfCheckOut,
                          List<Maintenance> maintenanceOrder);
}
