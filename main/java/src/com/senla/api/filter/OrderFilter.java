package com.senla.api.filter;

import java.time.LocalDate;

public class OrderFilter {
    private LocalDate targetDate;

    public LocalDate getTargetDate () {
        return targetDate;
    }

    public void setTargetDate (LocalDate targetDate) {
        this.targetDate= targetDate;
    }

}
