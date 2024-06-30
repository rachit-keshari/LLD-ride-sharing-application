package com.transport.ride_sharing.service;

import com.transport.ride_sharing.model.Ride;
import com.transport.ride_sharing.model.Users;
import com.transport.ride_sharing.model.Vehicle;
import com.transport.ride_sharing.model.enums.SelectStrategy;
import com.transport.ride_sharing.repository.RideRepository;
import com.transport.ride_sharing.repository.UsersRepository;
import com.transport.ride_sharing.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Collections;
import java.util.List;

@Service
public class RideService {

    @Autowired
     private VehicleRepository vehicleRepository;
    @Autowired
    private RideRepository rideRepository;

    @Autowired
    private UsersRepository usersRepository;

     public void offer_ride(String name, String origin, int availableSeats, String vehicleName,
                            String vehicleNo, String destination, String startTime, String rideDuration){
         Vehicle vehicle = vehicleRepository.findByUserNameAndVehicleNameAndVehicleNo(name,vehicleName,vehicleNo);
         if(vehicle!=null){
             Ride ride = new Ride();
             ride.setOrigin(origin);
             ride.setDestination(destination);
             ride.setAvailableSeats(availableSeats);
             DateTimeFormatter dtf = new DateTimeFormatterBuilder()
                     .appendPattern("d['st']['nd']['rd']['th'] MMM, yyyy HH:mm")
                     .toFormatter();
             ride.setStartTime(LocalDateTime.parse(startTime,dtf));
             ride.setDuration(Integer.valueOf(rideDuration.replace(" hrs","").trim()));
             ride.setVehicle(vehicle);
             rideRepository.save(ride);
         }
     }

    public void select_ride(String name, String origin, String destination, SelectStrategy selectStrategy){
         if(SelectStrategy.FASTEST_RIDE.equals(selectStrategy)){
             List<Ride> rides= rideRepository.findByOriginAndDestinationAndAvailableSeatsGreaterThan(origin,destination,0);
             Collections.sort(rides,(a, b)->a.getDuration()-b.getDuration());
             if(rides.isEmpty()){
                 System.out.println("================== No rides found =================\n"); return;
             }else {
                 Ride ride = rides.get(0);
                 ride.setAvailableSeats(ride.getAvailableSeats() - 1);
                 rideRepository.save(ride);
                 Users user = usersRepository.findByName(name);
                 int fuleSaved = user.getFuleSaved();
                 user.setFuleSaved(fuleSaved + ride.getDuration());
                 usersRepository.save(user);
                 System.out.println("Ride Taken by: " + name + " RideOwner: " + ride.getVehicle().getUser().getName());
                 System.out.println("Ride origin: " + ride.getOrigin() + " Ride Destination: " + ride.getDestination());
                 System.out.println("fule saved: " + ride.getDuration());
                 System.out.println("Total fule saved by each riders: ");
                 List<Object[]> fuleUsedMap = usersRepository.findAllNameAndFuleSaved();
                 for (Object[] obj : fuleUsedMap) {
                     System.out.println("[" + (String) obj[0] + ":" + (Integer) obj[1] + "] ");
                 }
                 System.out.println("\n");
             }
         } else {
             List<Ride> rides= rideRepository.findByOriginAndDestinationAndAvailableSeatsGreaterThan(origin,destination,0);
             Collections.sort(rides,(a, b)->a.getStartTime().compareTo(b.getStartTime()));
             if(rides.isEmpty()){
                 System.out.println("================== No rides found =================\n"); return;
             }else {
                 Ride ride = rides.get(0);
                 ride.setAvailableSeats(ride.getAvailableSeats() - 1);
                 rideRepository.save(ride);
                 Users user = usersRepository.findByName(name);
                 int fuleSaved = user.getFuleSaved();
                 user.setFuleSaved(fuleSaved + ride.getDuration());
                 usersRepository.save(user);
                 System.out.println("Ride Taken by: " + name + " RideOwner: " + ride.getVehicle().getUser().getName());
                 System.out.println("Ride origin: " + ride.getOrigin() + " Ride Destination: " + ride.getDestination());
                 System.out.println("fule saved: " + ride.getDuration());
                 System.out.println("Total fule saved by each riders: ");
                 List<Object[]> fuleUsedMap = usersRepository.findAllNameAndFuleSaved();
                 for (Object[] obj : fuleUsedMap) {
                     System.out.println("[" + (String) obj[0] + ":" + (Integer) obj[1] + "] ");
                 }
                 System.out.println("\n");
             }
         }
    }

    public void printRides(){
         List<Ride> rides = rideRepository.findAll();
        System.out.println();
         for(Ride r: rides){
             System.out.println(r.toString());
         }
        System.out.println();
    }

}
