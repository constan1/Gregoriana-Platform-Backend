package com.TransportListingService.TransportListingService.Service.Implementation;

import com.TransportListingService.TransportListingService.Repository.transportListingRepository;
import com.TransportListingService.TransportListingService.Repository.vehiclesRepository;
import com.TransportListingService.TransportListingService.Service.Services.transportService;
import com.TransportListingService.TransportListingService.model.TransportListing;
import com.TransportListingService.TransportListingService.model.vehicles;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class transportServiceImpl implements transportService {


    private final transportListingRepository transportListingRepository_;
    private final vehiclesRepository vehiclesRepository_;


    @Override
    public String insertVehicle(vehicles v)  throws Exception{

        Optional<vehicles> vehicles = Optional.ofNullable(vehiclesRepository_.getVehicles(v.getAuthID(), v.getEmail()));

        try {
            if(vehicles.isEmpty()) {
                vehiclesRepository_.save(v);
            }
            else {
                return "A vehicle is already registered!";
            }
        } catch (Exception e){
            return e.getMessage();
        }
        return "Success";
    }

    @Override
    public TransportListing getTransportListing(String authID) {

       return transportListingRepository_.getTransportListing(authID);
    }

    @Override
    public String insertTransportListing(TransportListing transportListing) throws Exception{

        /**\
         * Will also make a call to the Feedback-Microservice via circuit breaker pattern.
         */
        try {
            Optional<vehicles> vehicles = Optional.ofNullable(vehiclesRepository_.getVehicles(transportListing.getAuthID(), transportListing.getEmail()));
            Optional<TransportListing> transportListing_check = Optional.ofNullable(transportListingRepository_.getTransportListing(transportListing.getAuthID()));
            if (vehicles.isPresent() && transportListing_check.isEmpty()) {
                transportListing.setVehicle(vehicles.get());
                transportListingRepository_.save(transportListing);
                return "Success!";
            } else if(vehicles.isEmpty()) {
                return "Fail: No Vehicle Information Available.";
            } else {
                return "You already have an active listing";
            }
        }catch (Exception e){
            return e.getMessage();
        }
    }

}
