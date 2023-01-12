package com.TripService.TripService.resource;

import com.TripService.TripService.DTO.CreatedTripsDTO;
import com.TripService.TripService.model.Trip;
import com.TripService.TripService.service.services.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/createdTrip/")
public class TripResource {

    @Autowired  private TripService tripService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    private Trip createTrip(@RequestBody CreatedTripsDTO createdTripsDTO){
        return tripService.createTrip(createdTripsDTO);
    }
}
