package com.transport.ride_sharing;

import com.transport.ride_sharing.model.enums.SelectStrategy;
import com.transport.ride_sharing.service.RideService;
import com.transport.ride_sharing.service.UsersService;
import com.transport.ride_sharing.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Driver {
    @Autowired
    private UsersService usersService;
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private RideService rideService;

    public void start() {

        usersService.add_user("Rohan", "M", 36);
        vehicleService.add_vehicle("Rohan", "Swift", "KA-01-12345");
        usersService.add_user("Shashank", "M", 29);
        vehicleService.add_vehicle("Shashank", "Baleno", "TS-05-62395");
        usersService.add_user("Nandini", "F", 29);
        usersService.add_user("Shipra", "F", 27);
        vehicleService.add_vehicle("Shipra", "Polo", "KA-05-41491");
        vehicleService.add_vehicle("Shipra", "Scooty", "KA-12-12332");
        usersService.add_user("Gaurav", "M", 29);

        rideService.offer_ride("Rohan", "Hydrabad", 1, "Swift", "KA-01-12345",
                "Bangalore", "25th Jan, 2019 08:00", "13 hrs");
        rideService.offer_ride("Shipra", "Bangalore", 1, "Scooty", "KA-12-12332",
                "Mysore", "29th Jan, 2019 18:00", "10 hrs");
        rideService.offer_ride("Shipra", "Bangalore", 2, "Polo", "KA-05-41491",
                "Mysore", "30th Jan, 2019 18:00", "4 hrs");
        rideService.offer_ride("Shashank", "Hydrabad", 2, "Baleno", "TS-05-62395",
                "Bangalore", "27th Jan, 2019 10:00", "14 hrs");

        rideService.printRides();
        rideService.select_ride("Nandini","Bangalore","Mysore", SelectStrategy.FASTEST_RIDE);
        rideService.printRides();
        rideService.select_ride("Gaurav","Bangalore","Mysore", SelectStrategy.EARLIEST_RIDE);
        rideService.printRides();
        rideService.select_ride("Shashank","Mumbai","Bangalore", SelectStrategy.FASTEST_RIDE);
        rideService.printRides();
        rideService.select_ride("Rohan","Hydrabad","Bangalore", SelectStrategy.FASTEST_RIDE);
        rideService.printRides();
    }
}