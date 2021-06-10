package com.senla.api.service;

import com.senla.model.Maintenance;
import com.senla.model.Order;

import java.time.LocalDate;
import java.util.List;

public interface IOrderService {
    Order addOrder(Long guestId, Long roomId, LocalDate dateOfCheckIn, LocalDate dateOfCheckOut);

    double getRoomFullCost(Long orderId);

    List<Order> getLastThreeGuestsOrder(Long id);

    Maintenance addMaintenanceInOrder(Long maintenanceId, Long orderId, LocalDate date);
}
