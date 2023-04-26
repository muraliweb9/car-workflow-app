package com.interview.carworkflow.service;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;

import javax.inject.Named;

@Named
@Component
@Slf4j
public class FinaliseBookingListener implements ExecutionListener {

    @Override
    public void notify(DelegateExecution execution) throws Exception {
        String eventName = execution.getEventName();
        String name = execution.getCurrentActivityName();

        log.info("Finalise booking task [{}] had event [{}]", name, eventName);

    }
}
