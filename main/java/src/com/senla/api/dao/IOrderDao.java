package com.senla.api.dao;

import com.senla.model.Order;
import com.senla.model.Room;

import java.util.List;

public interface IOrderDao {
    void save (Order entity);
    Order getById (Long id);
    List<Order> getAll ();
    void delete (Order entity);
    Room update (Order entity);
}
