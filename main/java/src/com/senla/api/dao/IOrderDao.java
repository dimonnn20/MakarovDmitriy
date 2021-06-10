package com.senla.api.dao;

import com.senla.api.filter.OrderFilter;
import com.senla.model.Order;
import com.senla.model.Room;

import java.util.List;

public interface IOrderDao {
    void save(Order entity);

    Order getById(Long id);

    List<Order> getAll();

    void delete(Order entity);

    Order update(Order entity);

    List<Order> getAll(OrderFilter filter);

    List<Order> getAll(String sortName);

    List<Order> getAll(OrderFilter filter, String sortName);

}
