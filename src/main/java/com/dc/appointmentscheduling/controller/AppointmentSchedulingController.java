package com.dc.appointmentscheduling.controller;

import com.dc.appointmentscheduling.model.AppointmentScheduling;
import com.dc.appointmentscheduling.model.DcSlot;
import com.dc.appointmentscheduling.model.DctimeSlotRequest;
import com.dc.appointmentscheduling.sevice.AppointmentSchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointment")
public class AppointmentSchedulingController {

    @Autowired
    private AppointmentSchedulingService appointmentSchedulingService;


    @PostMapping("/add/appointment")
    public AppointmentScheduling addAppointment(@RequestBody DctimeSlotRequest dctimeSlotRequest){

          return  appointmentSchedulingService.addAppointmentSchedulling(dctimeSlotRequest);

}

    @GetMapping("/search/{doaId}")
    public  AppointmentScheduling searchAppointment(@PathVariable  Integer doaId){

      return   appointmentSchedulingService.searchAppointment(doaId);

}


  }


