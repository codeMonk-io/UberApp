////package com.rideshare.ride_service.service;
////
////import lombok.extern.slf4j.Slf4j;
////
////public class RideService {
////}
//
//package com.rideshare.ride_service.service;
//
//import org.springframework.stereotype.Service;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//
//@Service
//@RequiredArgsConstructor
//@Slf4j
//public class RideService {
//
//}


package com.rideshare.ride_service.service;

import com.rideshare.ride_service.dto.RideRequest;
import com.rideshare.ride_service.dto.RideResponse;
import com.rideshare.ride_service.event.RideRequestedEvent;
import com.rideshare.ride_service.model.Ride;
import com.rideshare.ride_service.model.RideStatus;
import com.rideshare.ride_service.repository.RideRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
@Service
@Slf4j
@RequiredArgsConstructor
public class RideService {
    private final RideRepository rideRepository;
    private final KafkaTemplate<String, RideRequestedEvent> KafkaTemplate;
    private static final String RIDE_REQUESTED_TOPIC="ride.requested";

//    create ride in db with requested status
public RideResponse requestRide(RideRequest request){
    log.info("new ride request from user", request.getRiderId());


    //Step 1: save ride to database
    Ride ride = new Ride();
    ride.setRiderId(request.getRiderId());
    ride.setPickupLatitude(request.getPickupLatitude());
    ride.setPickupLongitude(request.getPickupLongitude());
    ride.setPickupAddress(request.getPickupAddress());
    ride.setDropLatitude(request.getDropLatitude());
    ride.setDropLongitude(request.getDropLongitude());
    ride.setDropAddress(request.getDropAddress());
    ride.setStatus(RideStatus.REQUESTED);
    ride.setEstimatedFare(calculateEstimateFare(request));
}


}
