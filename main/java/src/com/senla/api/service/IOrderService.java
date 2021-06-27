package com.senla.api.service;

import com.senla.model.Order;

import java.time.LocalDate;
import java.util.List;

public interface IOrderService {
    Order addOrder(Long guestId, Long roomId, LocalDate dateOfCheckIn, LocalDate dateOfCheckOut);

    double getOrderFullCost(Long orderId);

    List<Order> getLastThreeGuestsOrdersByRoomId(Long id);

    void addMaintenanceToOrder(Long maintenanceId, Long orderId, LocalDate date);

    List<Order> getOrdersByGuestId(Long id);

    List<Order> getAllCurrentGuestsOrderBy(String sortName);

    List<Order> getAllCurrentGuestsOrderByGuestName();

    List<Order> getAllCurrentGuestsOrderByDate();

}
