package com.interview.carworkflow.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDetails {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String licenceNumber;
}
