package com.interview.carworkflow.service;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SelectVehicleService implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        log.info("Running SelectVehicleService !!");

        var map = delegateExecution.getVariables();

        map.entrySet().stream().forEach(e -> System.out.println(e));

        log.info("DelegateExecution {}", delegateExecution);

    }
}
