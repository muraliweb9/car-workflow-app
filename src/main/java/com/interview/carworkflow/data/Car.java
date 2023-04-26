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
public class Car {
    @Id
    private String id;

    private String registrationPlate;

    private String make;

    private String model;

    private String type;

    private String capacity;

    @OneToOne
    @JoinColumn(name = "location_id")
    private Location location;

}
