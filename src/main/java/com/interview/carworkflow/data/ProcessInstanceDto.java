package com.interview.carworkflow.data;

import lombok.Builder;
import lombok.Data;
import org.camunda.bpm.engine.runtime.ProcessInstance;

@Builder
@Data
public class ProcessInstanceDto {

    private String id;
    private String businessKey;
    private String processInstanceId;
    private String processDefinitionId;
    private String tenantId;
    private String rootProcessInstanceId;
    private String caseInstanceId;

    public static ProcessInstanceDto from(ProcessInstance processInstance) {

        return ProcessInstanceDto.builder()
                .id(processInstance.getId())
                .businessKey(processInstance.getBusinessKey())
                .processInstanceId(processInstance.getProcessInstanceId())
                .processDefinitionId(processInstance.getProcessDefinitionId())
                .tenantId(processInstance.getTenantId())
                .rootProcessInstanceId(processInstance.getRootProcessInstanceId())
                .caseInstanceId(processInstance.getCaseInstanceId())
                .build();

    }
}
