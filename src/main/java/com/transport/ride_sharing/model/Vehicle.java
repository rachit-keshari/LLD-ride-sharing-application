package com.transport.ride_sharing.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     private String vehicleName;
     private String vehicleNo;
     @ManyToOne
     private Users user;
}
