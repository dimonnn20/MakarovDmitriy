package com.senla.api.filter;

import com.senla.model.Guest;

import java.util.List;

public class GuestFilter {

    private List<Guest> ActiveGuests;

    public List<Guest> getCurrentGuests() {

        return ActiveGuests;
    }

    public void setCurrentGuests(List<Guest> activeGuests) {

        this.ActiveGuests = activeGuests;
    }

}
