package com.interview.carworkflow.service.listener;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.springframework.stereotype.Component;

import javax.inject.Named;

@Named
@Component
@Slf4j
public class HandoverVehicleTaskListener implements TaskListener {
    @Override
    public void notify(DelegateTask delegateTask) {
        String eventName = delegateTask.getEventName();
        String name = delegateTask.getName();

        Boolean allChecksDone = null;
        if (delegateTask.getVariables().get("allChecksDone") != null) {
            allChecksDone = (Boolean) delegateTask.getVariables().get("allChecksDone");
        }
        log.info("HandoverVehicleTaskListener task [{}] had event [{}] with status [{}]",
                name, eventName, allChecksDone);
    }
}
