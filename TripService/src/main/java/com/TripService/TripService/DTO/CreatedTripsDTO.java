package com.TripService.TripService.DTO;

import com.TripService.TripService.model.Orders;
import com.TripService.TripService.model.TripsMetadata;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CreatedTripsDTO {

    private String device_id;
    private ArrayList<Orders> orders;
    private TripsMetadata metadata;
}
