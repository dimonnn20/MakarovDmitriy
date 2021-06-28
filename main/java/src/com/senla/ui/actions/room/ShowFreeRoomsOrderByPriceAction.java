package com.senla.ui.actions.room;

import com.senla.api.service.IRoomService;
import com.senla.model.Room;
import com.senla.ui.actions.IAction;

import java.util.List;

public class ShowFreeRoomsOrderByPriceAction implements IAction {

    private final IRoomService roomService;

    public ShowFreeRoomsOrderByPriceAction(IRoomService roomService) {
        this.roomService = roomService;
    }

    @Override
    public void execute() {
        List<Room> freeRoomsOrderByPriceAction = roomService.getFreeRoomsOrderByPrice();
        freeRoomsOrderByPriceAction.forEach(System.out::println);
    }
}
