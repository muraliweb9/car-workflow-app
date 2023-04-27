package com.interview.carworkflow.service.listener;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;

import javax.inject.Named;

@Named
@Component
@Slf4j
public class EscalateToSupervisorTaskListener implements ExecutionListener {

    @Override
    public void notify(DelegateExecution execution) throws Exception {
        String eventName = execution.getEventName();
        String name = execution.getCurrentActivityName();

        log.info("EscalateToSupervisorTaskListener [{}] had event [{}]", name, eventName);

    }
}
