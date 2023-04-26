package com.interview.carworkflow.service;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.springframework.stereotype.Component;

import javax.inject.Named;

@Named
@Component
@Slf4j
public class VehicleHandoverListener implements TaskListener {
    @Override
    public void notify(DelegateTask delegateTask) {
      String eventName = delegateTask.getEventName();
      String name = delegateTask.getName();

      Boolean allChecksDone =  null;
      if (delegateTask.getVariables().get("allChecksDone") != null) {
          allChecksDone = (Boolean) delegateTask.getVariables().get("allChecksDone");
          if (allChecksDone) {
              log.info("Vehicle handover task [{}] had event [{}] with status {}", name, eventName, allChecksDone);
          }
          else {
              throw new BpmnError("CAR_NOT_UPTO_STANDARD", "Please instruct depot to rectify car");
          }
      }
      else {
          log.info("Vehicle handover task FAILURE [{}] had event [{}] with status {}", name, eventName, allChecksDone);
          throw new BpmnError("CAR_NOT_UPTO_STANDARD", "Please instruct depot to rectify car");
      }


    }
}
