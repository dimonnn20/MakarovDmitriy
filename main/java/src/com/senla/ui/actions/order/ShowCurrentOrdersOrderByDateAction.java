package com.senla.ui.actions.order;

import com.senla.api.service.IOrderService;
import com.senla.model.Order;
import com.senla.ui.actions.IAction;

import java.util.List;

public class ShowCurrentOrdersOrderByDateAction implements IAction {

    private final IOrderService orderService;

    public ShowCurrentOrdersOrderByDateAction(IOrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void execute() {
        List<Order> currentOrdersOrderByAction = orderService.getAllCurrentGuestsOrderByDate();
        currentOrdersOrderByAction.forEach(System.out::println);
    }
}
