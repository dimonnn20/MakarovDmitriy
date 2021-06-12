package com.senla.api.service;

import com.senla.model.Guest;
import com.senla.model.Order;

import java.util.List;

public interface IGuestService {

    Guest addGuest(String name, Integer age);

    List<Order> getAllCurrentGuestsByAlphabet();

    List<Order> getAllCurrentGuestsByDate();

}
