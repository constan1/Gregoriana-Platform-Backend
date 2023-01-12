package com.TripService.TripService.apiProxy;


import com.TripService.TripService.config.FeignClientConfig;
import com.TripService.TripService.DTO.CreatedTripsDTO;
import com.TripService.TripService.model.Trip;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "createTrip-api", configuration = FeignClientConfig.class, url = "https://v3.api.hypertrack.com/trips")
public interface createTripProxy {

    @RequestMapping(method = RequestMethod.POST)
    Trip responseTrip(@RequestBody CreatedTripsDTO createdTripsDTO);

}
