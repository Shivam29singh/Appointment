package com.dc.appointmentscheduling.sevice;

import com.dc.appointmentscheduling.dao.AppointmentSchedulingDao;
import com.dc.appointmentscheduling.model.AppointmentScheduling;
import com.dc.appointmentscheduling.model.DcSlot;
import com.dc.appointmentscheduling.model.DctimeSlotRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface AppointmentSchedulingService  {

  AppointmentScheduling addAppointmentSchedulling(DctimeSlotRequest dctimeSlotRequest);

  AppointmentScheduling searchAppointment(Integer doaId);


}
