package com.dc.appointmentscheduling;

import com.dc.appointmentscheduling.controller.AppointmentSchedulingController;
import com.dc.appointmentscheduling.model.AppointmentScheduling;
import com.dc.appointmentscheduling.sevice.AppointmentSchedulingService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.ArgumentMatchers.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class AppointmentSchedulingApplicationTests {


	@InjectMocks
	AppointmentSchedulingController appointmentSchedulingController;
    @Mock
	AppointmentSchedulingService service;

	@Test
  public void contextLoads() {
	}

	@Test
	public void addAppointmentTest(){
		AppointmentScheduling appointmentScheduling = new AppointmentScheduling();
		appointmentScheduling.setDoaId(200);

		Mockito.when(service.addAppointmentSchedulling(any())).thenReturn(appointmentScheduling);
		  AppointmentScheduling scheduling =      appointmentSchedulingController.addAppointment(any());
		  Assert.assertEquals((Integer) 200, (Integer) scheduling.getDoaId());

	}

	@Test
	public void  searchAppointmentTest(){
		AppointmentScheduling appointmentScheduling = new AppointmentScheduling();
		appointmentScheduling.setDoaId(500);
		Mockito.when(service.searchAppointment(anyInt())).thenReturn(appointmentScheduling);
		 AppointmentScheduling scheduling =  appointmentSchedulingController.searchAppointment(anyInt());
		Assert.assertEquals((Integer) 500, (Integer) scheduling.getDoaId());
	}

}
