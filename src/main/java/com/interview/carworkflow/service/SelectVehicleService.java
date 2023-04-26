package com.interview.carworkflow.service;

import com.interview.carworkflow.data.Car;
import com.interview.carworkflow.data.Location;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import javax.inject.Named;

@Component
@Slf4j
@Named
public class SelectVehicleService implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        log.info("Running SelectVehicleService !!");
        Location loc = Location.builder()
                .id("1")
                .locationName("Toronto").build();
        Car car = Car.builder()
                .id("1")
                .make("Audi")
                .model("Q7")
                .type("SUV")
                .capacity("7")
                .registrationPlate("LL75MVB")
                .location(loc).build();

        delegateExecution.setVariable("car", car);

        log.info("Car {} has been selected", car);

    }
}
