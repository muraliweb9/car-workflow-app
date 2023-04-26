package com.interview.carworkflow.service;

//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import io.swagger.v3.oas.annotations.tags.Tag;

import com.interview.carworkflow.data.CustomerDetails;
import com.interview.carworkflow.data.ProcessInstanceDto;
import com.interview.carworkflow.data.TaskCompletionStatus;
import com.interview.carworkflow.data.VehicleHandoverDetails;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

//@Tag(name = "Booking Service", description = "Car Hire Booking Service")
@RestController
@RequestMapping("/carworkflow")
@Validated
@Slf4j
public class CarWorkflowService {

    private static final String CAR_WORKFLOW_PROCESS_ID = "car-workflow-app-process";

    private static final String ENTER_CUST_DETAILS_TASK_ID = "enter-customer-details";

    private static final String VEHICLE_HANDOVER_TASK_ID = "vehicle-handover";

    @Autowired
    private BpmApiService bpmApiService;

    //    @Operation(
//            summary = "Start Process Instance",
//            description = "tart Process Instance",
//            tags = { "startProcess", "post" })
//    @ApiResponses({
//            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(), mediaType = "application/json") }),
//            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
//            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PostMapping("startProcess")
    public ProcessInstanceDto startProcess() {
        ProcessInstance processInstance = bpmApiService.getRuntimeService()
                .startProcessInstanceByKey(CAR_WORKFLOW_PROCESS_ID);

        return ProcessInstanceDto.from(processInstance);

    }

    @PostMapping("enterCustomerDetails/{processInstanceId}")
    public TaskCompletionStatus enterCustomerDetails(@PathVariable String processInstanceId, @RequestBody CustomerDetails customerDetails) {
        String firstName = customerDetails.getFirstName();
        String lastName = customerDetails.getLastName();
        String licenceNumber = customerDetails.getLicenceNumber();

        TaskService taskService = bpmApiService.getTaskService();

        Task task = taskService.createTaskQuery().processInstanceId(processInstanceId)
                .taskDefinitionKey(ENTER_CUST_DETAILS_TASK_ID).singleResult();

        taskService.complete(task.getId(),
                Map.of("firstName", firstName,
                        "lastName", lastName,
                        "licenceNumber", licenceNumber));

        return TaskCompletionStatus.COMPLETED;

    }

    @PostMapping("vehicleHandover/{processInstanceId}")
    public TaskCompletionStatus vehicleHandover(@PathVariable String processInstanceId,
                                                @RequestBody VehicleHandoverDetails vehicleHandoverDetails) {
        boolean allChecksDone = vehicleHandoverDetails.allChecksDone();

        //if (allChecksDone) {
            TaskService taskService = bpmApiService.getTaskService();

            Task task = taskService.createTaskQuery().processInstanceId(processInstanceId)
                    .taskDefinitionKey(VEHICLE_HANDOVER_TASK_ID).singleResult();

            taskService.complete(task.getId(),
                    Map.of("allChecksDone", Boolean.valueOf(allChecksDone)));

            return TaskCompletionStatus.COMPLETED;
        //}
        //return TaskCompletionStatus.INCOMPLETE;
        //



    }
}
