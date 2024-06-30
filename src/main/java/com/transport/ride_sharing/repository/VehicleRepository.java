package com.transport.ride_sharing.repository;

import com.transport.ride_sharing.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
    Vehicle findByUserNameAndVehicleNameAndVehicleNo(String name,String vehicleName,String vehicleNo);
}
