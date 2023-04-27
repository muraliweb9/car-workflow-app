package com.interview.carworkflow.service.consts;

import lombok.Data;
import lombok.Getter;
import org.camunda.bpm.engine.delegate.BpmnError;

@Getter
public enum ErrorCode {

    HANDOVER_FAILURE("HANDOVER_FAIL_1", "The car did not meet quality criteria"),
    FINALISE_FAILURE("FINALISE_FAIL_1", "The customer details incomplete");

    String errCode;
    String errMessage;

    private ErrorCode(String errCode, String errMessage) {
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

    public BpmnError bpmnError() {
        return new BpmnError(errCode, errMessage);
    }
}
