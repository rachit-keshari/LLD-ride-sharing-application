package com.transport.ride_sharing.service;

import com.transport.ride_sharing.model.Users;
import com.transport.ride_sharing.model.Vehicle;
import com.transport.ride_sharing.repository.UsersRepository;
import com.transport.ride_sharing.repository.VehicleRepository;
import org.hibernate.engine.jdbc.connections.internal.UserSuppliedConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    public void add_vehicle(String name,String vehicleName, String vehicleNo){
        Users user = usersRepository.findByName(name);
        if(user!=null){
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleName(vehicleName);
            vehicle.setVehicleNo(vehicleNo);
            vehicle.setUser(user);
            vehicleRepository.save(vehicle);
        }
    }
}
