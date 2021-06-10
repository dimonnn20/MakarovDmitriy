package com.senla.comparator.guest;

import com.senla.model.Guest;

import java.util.Comparator;

public class GuestDateComparator implements Comparator<Guest> {
    @Override
    public int compare(Guest o1, Guest o2) {
        return o1.getDateOfCheckOut().compareTo(o2.getDateOfCheckOut());
    }
}
