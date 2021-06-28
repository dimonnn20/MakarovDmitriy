package com.senla.ui.actions.order;

import com.senla.api.service.IOrderService;
import com.senla.ui.actions.IAction;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AddOrderAction implements IAction {

    private final IOrderService orderService;

    public AddOrderAction(IOrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите ИД гостя");
        Long guestId = Long.parseLong(scanner.next());
        System.out.println("Введите ИД номера");
        Long roomId = Long.parseLong(scanner.next());
        System.out.println("Введите дату заселения в формате yyyy-MM-dd ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateOfCheckIn = LocalDate.parse(scanner.next(), formatter);
        System.out.println("Введите дату выселения в формате yyyy-MM-dd ");
        LocalDate dateOfCheckOut = LocalDate.parse(scanner.next(), formatter);
        orderService.addOrder(guestId, roomId, dateOfCheckIn, dateOfCheckOut);
    }
}
