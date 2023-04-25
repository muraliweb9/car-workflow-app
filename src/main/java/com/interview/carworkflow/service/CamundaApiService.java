package com.interview.carworkflow.service;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Data
@Slf4j
public class CamundaApiService {
    @Autowired
    private ProcessEngine processEngine = null;

    public RuntimeService getRuntimeService() {
        return processEngine.getRuntimeService();
    }

    public TaskService getTaskService() {
        return processEngine.getTaskService();
    }

}
