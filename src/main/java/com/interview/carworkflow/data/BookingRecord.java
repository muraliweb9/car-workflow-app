package com.interview.carworkflow.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingRecord {

    @Id
    private String id;

    @OneToOne
    @JoinColumn(name = "customerdetails_id")
    private CustomerDetails customerDetails;

    @OneToOne
    @JoinColumn(name = "car_id")
    private Car car;

    private boolean allChecksDone;

}
