package com.transport.ride_sharing.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Users {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String name;
     private String gender;
     private Integer age;
     private Integer fuleSaved = 0;
}
