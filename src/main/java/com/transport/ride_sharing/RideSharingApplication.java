package com.transport.ride_sharing;

import com.transport.ride_sharing.service.RideService;
import com.transport.ride_sharing.service.UsersService;
import com.transport.ride_sharing.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RideSharingApplication {


	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(RideSharingApplication.class, args);
		Driver driver = context.getBean(Driver.class);
		driver.start();
	}

}
