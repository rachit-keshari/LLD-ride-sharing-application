package com.transport.ride_sharing.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table
@Data
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     private String origin;
     private String destination;
     private Integer availableSeats;
     private LocalDateTime startTime;
     private Integer duration;
     @ManyToOne
     private Vehicle vehicle;
}
