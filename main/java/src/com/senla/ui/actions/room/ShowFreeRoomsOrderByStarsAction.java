package com.senla.ui.actions.room;

import com.senla.api.service.IRoomService;
import com.senla.model.Room;
import com.senla.ui.actions.IAction;

import java.util.List;

public class ShowFreeRoomsOrderByStarsAction implements IAction {

    private final IRoomService roomService;

    public ShowFreeRoomsOrderByStarsAction(IRoomService roomService) {
        this.roomService = roomService;
    }

    @Override
    public void execute() {
        List<Room> freeRoomsOrderByStarsAction = roomService.getFreeRoomsOrderByStars();
        freeRoomsOrderByStarsAction.forEach(System.out::println);
    }
}
