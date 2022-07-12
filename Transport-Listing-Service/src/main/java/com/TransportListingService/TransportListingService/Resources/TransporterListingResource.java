package com.TransportListingService.TransportListingService.Resources;


import com.TransportListingService.TransportListingService.Service.Services.transportService;
import com.TransportListingService.TransportListingService.model.TransportListing;
import com.TransportListingService.TransportListingService.model.vehicles;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/transport-listing/")
@RequiredArgsConstructor
public class TransporterListingResource {

    private final transportService transportService_;

    @PostMapping("vehicle")
    @ResponseStatus(HttpStatus.CREATED)
    private String saveVehicle(@RequestBody vehicles v) throws Exception {
        return transportService_.insertVehicle(v);
    }

    @GetMapping("transportListing/{authID}")
    @ResponseStatus(HttpStatus.OK)
    private TransportListing getTransportListing (@PathVariable(name = "authID") String authID){
        return transportService_.getTransportListing(authID);
    }

    @PostMapping("transportListing")
    @ResponseStatus(HttpStatus.CREATED)
    private String insertTransportListing (@RequestBody TransportListing transportListing) throws Exception {
        return transportService_.insertTransportListing(transportListing);
    }


}
