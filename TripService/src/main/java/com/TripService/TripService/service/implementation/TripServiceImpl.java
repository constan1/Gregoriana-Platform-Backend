package com.TripService.TripService.service.implementation;


import com.TripService.TripService.DTO.CreatedTripsDTO;
import com.TripService.TripService.apiProxy.createTripProxy;
import com.TripService.TripService.model.Trip;
import com.TripService.TripService.service.services.TripService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripServiceImpl implements TripService{

   @Autowired private createTripProxy tripService;


    @Override
    public Trip createTrip(CreatedTripsDTO createdTripsDTO) {
       return tripService.responseTrip(createdTripsDTO);
    }
}
