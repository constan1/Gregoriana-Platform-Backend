package com.TripService.TripService.model;

import lombok.Data;

@Data
public class Trip {

    private String trip_id;
    private String started_at;
    private String status;
    private Views views;
}
