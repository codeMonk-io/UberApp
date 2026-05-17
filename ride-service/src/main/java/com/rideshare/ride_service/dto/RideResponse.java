package com.rideshare.ride_service.dto;

import com.rideshare.matching_service.model.RideStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

public class RideResponse {
    private String id;
    private String riderId;
    private String driverId;

    private double pickupLatitude;
    private double pickupLongitude;
    private String pickupAddress;

    private double dropLatitude;
    private double dropLongitude;
    private String dropAddress;

    //ride status , it track the lifecycyle
    private RideStatus status;

    private double estimateFare ;
    private double actualFare ;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime startedAt;
    private LocalDateTime completedAt;


}
