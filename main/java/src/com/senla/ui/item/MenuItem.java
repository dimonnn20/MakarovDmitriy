package com.senla.ui.item;

import com.senla.ui.actions.IAction;
import com.senla.ui.menu.Menu;

public class MenuItem {
    private final String title;
    private final IAction action;
    private final Menu nextMenu;

    public MenuItem(String title, IAction action, Menu nextMenu) {
        this.title = title;
        this.action = action;
        this.nextMenu = nextMenu;
    }

    public void doAction() {
        if (action != null) {
            action.execute();
        }
    }

    public String getTitle() {
        return title;
    }

    public IAction getAction() {
        return action;
    }

    public Menu getNextMenu() {
        return nextMenu;
    }

}
