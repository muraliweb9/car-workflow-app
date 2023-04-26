package com.interview.carworkflow.service;

import com.interview.carworkflow.data.BookingRecord;
import com.interview.carworkflow.data.Car;
import com.interview.carworkflow.data.CustomerDetails;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import javax.inject.Named;

@Component
@Slf4j
@Named
public class FinaliseBookingService implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        log.info("Running FinaliseBookingService !!");

        var map = delegateExecution.getVariables();

        CustomerDetails cust = CustomerDetails.builder()
                .id("1")
                .firstName(map.get("firstName").toString())
                .lastName(map.get("lastName").toString())
                .licenceNumber(map.get("licenceNumber").toString())
                .build();

        Car car = (Car) map.get("car");

        boolean allChecksDone = true;

        BookingRecord record = BookingRecord.builder()
                .id("1")
                .customerDetails(cust)
                .car(car)
                .allChecksDone(allChecksDone)
                .build();

        log.info("Booking record {} has been created", record);


    }
}
