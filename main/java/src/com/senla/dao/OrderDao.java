package com.senla.dao;

import com.senla.api.dao.IOrderDao;
import com.senla.api.service.IOrderService;
import com.senla.model.Order;
import com.senla.model.Room;
import com.senla.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class OrderDao implements IOrderDao {
    private List <Order> orders = new ArrayList<>();

    @Override
    public void save(Order entity) {
        entity.setId(IdGenerator.generateOrderId());
        orders.add(entity);
    }

    @Override
    public Order getById(Long id) {
        for (Order order: orders) {
            if (id.equals(order.getId())) {
                return order;
            }
        }
        return null;
    }

    @Override
    public List<Order> getAll() {
        return orders;
    }

    @Override
    public void delete(Order entity) {
        for (Order order: orders) {
            if (order.equals(entity)) {
                orders.remove(order);
            }
        }
    }

    @Override
    public Room update(Order entity) {
        return null;
    }
}
