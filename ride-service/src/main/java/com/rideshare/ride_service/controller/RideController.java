package com.rideshare.ride_service.controller;

import com.rideshare.ride_service.dto.RideRequest;
import com.rideshare.ride_service.dto.RideResponse;
import com.rideshare.ride_service.service.RideService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rides")
@Slf4j
@RequiredArgsConstructor
public class RideController {
    private final RideService rideService;
    //rider req new ride
    @PostMapping("/request")
    public ResponseEntity<RideResponse> request (
            @Valid
            @RequestBody RideRequest rideRequest
    ){
        log.info("Ride Request recieved from rider id;{}",rideRequest.getRiderId());
        return  ResponseEntity.status(HttpStatus.CREATED).body(rideService.requestRide(rideRequest)) ;
    }

    @GetMapping("/{riderId}")
    public ResponseEntity<RideResponse>getRideById(
            @PathVariable String rideId ){
        return ResponseEntity.ok(rideService.getRideById(rideId));


    }
    @GetMapping("/rider/{riderId}")
    public ResponseEntity<List<RideResponse>>getRidesById(
            @PathVariable String riderId ){
        return ResponseEntity.ok(rideService.getRidesByRider(riderId));
    }
    // driver starts the ride
    @PutMapping("/{rideId}/start")
    public ResponseEntity<RideResponse>startRide(
            @PathVariable String rideId
    ){
        return ResponseEntity.ok(rideService.startRide(rideId));
    }

    @PutMapping("/{rideId}/complete")
    public ResponseEntity<RideResponse>completeRide(
            @PathVariable String rideId
    ){
        return ResponseEntity.ok(rideService.completeRide(rideId));
    }
    @PutMapping("/{rideId}/cancel")
    public ResponseEntity<RideResponse>completeRide(
            @PathVariable String rideId
    ){
        return ResponseEntity.ok(rideService.cancelRide(rideId));
    }



}
