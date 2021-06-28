package com.senla.comparator.guest;

import com.senla.model.Guest;

import java.util.Comparator;

public class GuestNameComparator implements Comparator<Guest> {

    @Override
    public int compare(Guest o1, Guest o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
