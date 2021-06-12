package com.senla.api.filter;

import com.senla.model.Guest;

import java.util.List;

public class GuestFilter {

    private List<Guest> activeGuests;

    public List<Guest> getCurrentGuests() {
        return activeGuests;
    }

    public void setCurrentGuests(List<Guest> activeGuests) {
        this.activeGuests = activeGuests;
    }
}
