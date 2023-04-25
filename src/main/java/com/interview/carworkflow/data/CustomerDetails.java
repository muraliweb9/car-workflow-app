package com.interview.carworkflow.data;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CustomerDetails {
    private String firstName;
    private String lastName;
    private String licenceNumber;
}
