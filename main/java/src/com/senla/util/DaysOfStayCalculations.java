package com.senla.util;

import com.senla.model.Order;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DaysOfStayCalculations {

    public static Long getDayOfStay (String dateOfCheckIn, String dateOfCheckOut) {
        //final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDate date1 = LocalDate.parse(dateOfCheckIn, formatter);
        LocalDate date2 = LocalDate.parse(dateOfCheckOut);
        return  ChronoUnit.DAYS.between(date1,date2);
    }


}
