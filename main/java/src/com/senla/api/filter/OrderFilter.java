package com.senla.api.filter;

import java.time.LocalDate;

public class OrderFilter {
    private LocalDate targetDate;
    private Long targetGuestId;

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public Long getTargetGuestId() {
        return targetGuestId;
    }

    public void setTargetGuestId(Long id) {
        this.targetGuestId = id;
    }
}
