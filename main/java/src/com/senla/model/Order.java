package com.senla.model;
import com.senla.util.DaysOfStayCalculations;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Order extends AEntity {
    private String dateOfCheckIn;
    private String dateOfCheckOut;
    private Long guestOrderId;
    private Long roomOrderId;
    private List<Maintenance> maintenanceOrder;
    private Long dayOfStay;

    public Order (Long guestOrderId, Long roomOrderId, String dateOfCheckIn, String dateOfCheckOut,
                  List <Maintenance> maintenanceOrder) {
        this.guestOrderId = guestOrderId;
        this.roomOrderId = roomOrderId;
        this.dateOfCheckIn = dateOfCheckIn;
        this.dateOfCheckOut = dateOfCheckOut;
        this.maintenanceOrder = maintenanceOrder;
        dayOfStay= DaysOfStayCalculations.getDayOfStay(dateOfCheckIn, dateOfCheckOut);
    }

    public  String getDateOfCheckIn() {
        return dateOfCheckIn;
    }

    public  String getDateOfCheckOut() {
        return dateOfCheckOut;
    }



    public Long getGuestOrderId() {
        return guestOrderId;
    }

    public Long getRoomOrderId() {
        return roomOrderId;
    }

    public List<Maintenance> getMaintenanceOrder() {
        return maintenanceOrder;
    }

    public void setDateOfCheckIn(String dateOfCheckIn) {
        this.dateOfCheckIn = dateOfCheckIn;
    }

    public void setDateOfCheckOut(String dateOfCheckOut) {
        this.dateOfCheckOut = dateOfCheckOut;
    }


    public void setGuestOrderId(Long guestOrderId) {
        this.guestOrderId = guestOrderId;
    }

    public void setRoomOrderId(Long roomOrderId) {
        this.roomOrderId = roomOrderId;
    }

    public void setMaintenanceOrder(List<Maintenance> maintenanceOrder) {
        this.maintenanceOrder = maintenanceOrder;
    }

    @Override
    public String toString() {
        return "Order{" +
                "dateOfCheckIn='" + dateOfCheckIn + '\'' +
                ", dateOfCheckOut='" + dateOfCheckOut + '\'' +
                ", guestOrderId=" + guestOrderId +
                ", roomOrderId=" + roomOrderId +
                ", maintenanceOrder=" + maintenanceOrder +
                ", dayOfStay=" + dayOfStay +
                '}';
    }
}
