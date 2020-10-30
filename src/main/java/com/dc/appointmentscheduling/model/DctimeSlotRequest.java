package com.dc.appointmentscheduling.model;

public class DctimeSlotRequest {

private Long dcNumber;
private String truck;

    private String dcTimeSlot;


    public DctimeSlotRequest() {
    }

    public DctimeSlotRequest(Long dcNumber, String truck, String dcTimeSlot) {
        this.dcNumber = dcNumber;
        this.truck = truck;
        this.dcTimeSlot = dcTimeSlot;
    }

    public Long getDcNumber() {
        return dcNumber;
    }

    public void setDcNumber(Long dcNumber) {
        this.dcNumber = dcNumber;
    }

    public String getTruck() {
        return truck;
    }

    public void setTruck(String truck) {
        this.truck = truck;
    }

    public String getDcTimeSlot() {
        return dcTimeSlot;
    }

    public void setDcTimeSlot(String dcTimeSlot) {
        this.dcTimeSlot = dcTimeSlot;
    }
}
