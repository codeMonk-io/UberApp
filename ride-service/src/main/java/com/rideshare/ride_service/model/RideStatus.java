package com.rideshare.ride_service.model;
/*
* flow
* requested > matching > accepted > driver arriving > ride > started
* completed
* cancelled (at multiple stages)
* */

public enum RideStatus {
    REQUESTED,
    MATCHING,
    ACCEPTED,
    DRIVER_ARRIVING,
    CANCELLED,
    COMPLETED
}