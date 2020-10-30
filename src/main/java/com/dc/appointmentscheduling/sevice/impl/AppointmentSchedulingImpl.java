package com.dc.appointmentscheduling.sevice.impl;

import com.dc.appointmentscheduling.dao.AppointmentSchedulingDao;
import com.dc.appointmentscheduling.model.*;
import com.dc.appointmentscheduling.sevice.AppointmentSchedulingService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Date;


@Service
public class AppointmentSchedulingImpl implements AppointmentSchedulingService {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private AppointmentSchedulingDao appointmentSchedulingDao;



    @HystrixCommand(fallbackMethod = "difaultfindbydcnuber")
    private Truck findBytruckNumber(String truckNumber ){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        System.out.println(entity);

        Truck truck  = restTemplate.exchange("http://localhost:8095/truck/search/truck/{truckNumber}", HttpMethod.GET, entity, Truck.class, truckNumber).getBody();
        logger.debug("sdfdsf", truck);
        return  truck;
    }


    private  String difaultfindbydcnuber(){
        System.out.println("inside fallback");
        return  null;
    }


    @HystrixCommand(fallbackMethod = "difaultfindbydcnuber")
    private DcSlot findByDcSlot(DctimeSlotRequest dctimeSlotRequest){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);


        String dctimeTimeSlot = dctimeSlotRequest.getDcTimeSlot();

        Long dcNumber = dctimeSlotRequest.getDcNumber();

//       DistributionCenter distributionCenter = restTemplate.exchange("http://localhost:8084/dcSlot/search/dcTimeSlot/{dctimeTimeSlot}/", HttpMethod.GET, entity, DcSlot.class, dctimeTimeSlot).getBody().getDistributionCenter();
//        Integer DcSlotId =  restTemplate.exchange("http://localhost:8084/dcSlot/search/dcTimeSlot/{dctimeTimeSlot}", HttpMethod.GET, entity, DcSlot.class, dctimeTimeSlot).getBody().getDcSlotId();
//        String DcTimeSlot = restTemplate.exchange("http://localhost:8084/dcSlot/search/dcTimeSlot/{dctimeTimeSlot}", HttpMethod.GET, entity, DcSlot.class, dctimeTimeSlot).getBody().getDcTimeSlot();
//        Integer Truck = restTemplate.exchange("http://localhost:8084/dcSlot/search/dcTimeSlot/{dctimeTimeSlot}", HttpMethod.GET, entity, DcSlot.class, dctimeTimeSlot).getBody().getMaxTruck();


        DcSlot dcSlot = restTemplate.exchange("http://localhost:8084/dcSlot/search/dcTimeSlot/{dctimeTimeSlot}/{dcNumber}", HttpMethod.GET, entity, DcSlot.class, dctimeTimeSlot,dcNumber).getBody();
//
//        logger.debug("sdfdsf", dcSlot);
        System.out.println("sfdsfds" + dcSlot);
        return  dcSlot;
    }

    @HystrixCommand(fallbackMethod = "difaultfindbydcnuber")
    private DistributionCenter findBydcNumber(Long dcNumber){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        System.out.println(entity);

        DistributionCenter distributionCenter  = restTemplate.exchange("http://localhost:8080/distributioncenter/search/dc/{dcNumber}", HttpMethod.GET, entity, DistributionCenter.class, dcNumber).getBody();
        logger.debug("sdfdsf", distributionCenter);
        return  distributionCenter;
    }


    @Override
    public AppointmentScheduling addAppointmentSchedulling(DctimeSlotRequest dctimeSlotRequest) {

        if (this.findBytruckNumber(dctimeSlotRequest.getTruck() ) != null){

            if (this.findByDcSlot(dctimeSlotRequest) != null){
                AppointmentScheduling appointmentScheduling = new AppointmentScheduling();
                appointmentScheduling.setTruck(this.findBytruckNumber(dctimeSlotRequest.getTruck() ));
                appointmentScheduling.setDcSlot(this.findByDcSlot(dctimeSlotRequest) );
                appointmentScheduling.setDistributionCenter(this.findByDcSlot(dctimeSlotRequest).getDistributionCenter());
                appointmentScheduling.setDateOfAppointment(new Date());
                appointmentSchedulingDao.save(appointmentScheduling);
                return  appointmentScheduling;
            }
        }


        return  null;
    }

    @Override
    public AppointmentScheduling searchAppointment(Integer doaId) {


        if (appointmentSchedulingDao.findByDoaId(doaId) != null){
            return appointmentSchedulingDao.findByDoaId(doaId);
        }
        return null;
    }


}
