package com.TripService.TripService.service.services;

import com.TripService.TripService.DTO.CreatedTripsDTO;
import com.TripService.TripService.model.Trip;

public interface TripService {

    Trip createTrip(CreatedTripsDTO createdTripsDTO);
}
