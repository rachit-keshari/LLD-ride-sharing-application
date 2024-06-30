package com.transport.ride_sharing.repository;

import com.transport.ride_sharing.model.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RideRepository extends JpaRepository<Ride,Long> {
    List<Ride> findByOriginAndDestinationAndAvailableSeatsGreaterThan(String origin, String destination, int availableSeats);
}
