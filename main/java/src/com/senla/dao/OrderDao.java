package com.senla.dao;

import com.senla.api.dao.IOrderDao;
import com.senla.api.filter.OrderFilter;
import com.senla.comparator.order.OrderLastDateComparator;
import com.senla.comparator.order.OrderNameComparator;
import com.senla.comparator.order.OrderStartDateComparator;
import com.senla.filter.predicate.order.OrderFilterPredicate;
import com.senla.model.Order;
import com.senla.util.IdGenerator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class OrderDao implements IOrderDao {
    private List<Order> orders = new ArrayList<>();

    @Override
    public void save(Order entity) {
        entity.setId(IdGenerator.generateOrderId());
        orders.add(entity);
    }

    @Override
    public Order getById(Long id) {
        for (Order order : orders) {
            if (id.equals(order.getId())) {
                return order;
            }
        }
        return null;
    }

    @Override
    public List<Order> getAll() {
        return getAll(null, null);
    }

    @Override
    public void delete(Order entity) {
        orders.remove(getById(entity.getId()));
    }

    @Override
    public Order update(Order entity) {
        Order order = getById(entity.getId());
        order.setDateOfCheckIn(entity.getDateOfCheckIn());
        order.setDateOfCheckOut(entity.getDateOfCheckOut());
        return order;
    }

    @Override
    public List<Order> getAll(OrderFilter filter) {
        return getAll(filter, null);
    }

    @Override
    public List<Order> getAll(String sortName) {
        return getAll(null, sortName);
    }

    @Override
    public List<Order> getAll(OrderFilter filter, String sortName) {
        List<Order> results = new ArrayList<>();

        Predicate<Order> filterPredicate = getPredicateByFilter(filter);
        if (filterPredicate != null) {
            for (Order entity : orders) {
                if (filterPredicate.test(entity)) {
                    results.add(entity);
                }
            }
        } else {
            results.addAll(orders);
        }
        Comparator<Order> comparator = getComparatorBySortName(sortName);
        if (comparator != null) {
            results.sort(comparator);
        }
        return results;

    }

    private Comparator<Order> getComparatorBySortName(String sortName) {
        if ("startDate".equals(sortName)) {
            return new OrderStartDateComparator();
        }
        if ("lastDate".equals(sortName)) {
            return new OrderLastDateComparator();
        }
        if ("name".equals(sortName)) {
            return new OrderNameComparator();
        }
        return null;
    }

    private Predicate<Order> getPredicateByFilter(OrderFilter filter) {
        return new OrderFilterPredicate(filter);
    }
}
