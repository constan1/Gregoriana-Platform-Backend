package com.TransportListingService.TransportListingService.Service.Services;

import com.TransportListingService.TransportListingService.model.TransportListing;
import com.TransportListingService.TransportListingService.model.vehicles;

public interface transportService {

    String insertVehicle(vehicles v) throws Exception;

    TransportListing getTransportListing(String authID);

    String insertTransportListing(TransportListing transportListing) throws Exception;


}
