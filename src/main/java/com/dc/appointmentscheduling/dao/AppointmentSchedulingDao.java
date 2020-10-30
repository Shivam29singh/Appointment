package com.dc.appointmentscheduling.dao;


import com.dc.appointmentscheduling.model.AppointmentScheduling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentSchedulingDao extends JpaRepository<AppointmentScheduling, Integer> {

    AppointmentScheduling findByDoaId(Integer doaId);
}
