package com.senla.api.filter;

import java.time.LocalDate;

public class OrderFilter {
    private LocalDate targetDate;
    private Long targetGuestId;
    private long targetRoomId;

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

    public Long getTargetRoomId () {
        return targetRoomId;
    }

    public void setTargetRoomId (Long id) {
        this.targetRoomId=targetRoomId;
    }
}
