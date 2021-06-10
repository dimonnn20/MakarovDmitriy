package com.senla.filter.predicate.guest;

import com.senla.api.filter.GuestFilter;
import com.senla.model.Guest;

import java.util.function.Predicate;

public class GuestFilterPredicate implements Predicate<Guest> {
    private final GuestFilter guestFilter;

    public GuestFilterPredicate(GuestFilter guestFilter) {
        this.guestFilter = guestFilter;
    }

    @Override
    public boolean test(Guest guest) {
        if (guestFilter == null) {
            return true;
        }
        if (guestFilter.getCurrentGuests() != null) {
            if (!guestFilter.getCurrentGuests().contains(guest)) {
                return false;
            }
        }
        return true;
    }
}
