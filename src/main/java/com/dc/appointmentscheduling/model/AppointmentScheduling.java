package com.dc.appointmentscheduling.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class AppointmentScheduling {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer doaId;

    private  String poNumber;
    private Date dateOfAppointment;

    @ManyToOne
    @JoinColumn(name = "dcNumber")
    private DistributionCenter distributionCenter;

    @ManyToOne
    @JoinColumn(name = "dcSlotId")
     private DcSlot  dcSlot ;

    @OneToOne
    @JoinColumn(name = "truckId")
    private  Truck truck;

    public AppointmentScheduling() {
    }

    public AppointmentScheduling(Integer doaId, String poNumber, Date dateOfAppointment, DistributionCenter distributionCenter, DcSlot dcSlot, Truck truck) {
        this.doaId = doaId;
        this.poNumber = poNumber;
        this.dateOfAppointment = dateOfAppointment;
        this.distributionCenter = distributionCenter;
        this.dcSlot = dcSlot;
        this.truck = truck;
    }

    public Integer getDoaId() {
        return doaId;
    }

    public void setDoaId(Integer doaId) {
        this.doaId = doaId;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public Date getDateOfAppointment() {
        return dateOfAppointment;
    }

    public void setDateOfAppointment(Date dateOfAppointment) {
        this.dateOfAppointment = dateOfAppointment;
    }

    public DistributionCenter getDistributionCenter() {
        return distributionCenter;
    }

    public void setDistributionCenter(DistributionCenter distributionCenter) {
        this.distributionCenter = distributionCenter;
    }

    public DcSlot getDcSlot() {
        return dcSlot;
    }

    public void setDcSlot(DcSlot dcSlot) {
        this.dcSlot = dcSlot;
    }

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }
}
