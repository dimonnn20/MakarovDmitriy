package com.senla.api.service;

import com.senla.model.Guest;

import java.util.List;

public interface IGuestService {

    Guest addGuest(String name, Integer age);

    List<Guest> getAllCurrentGuestsByAlphabet();

    List<Guest> getAllCurrentGuestsByDate();

}
