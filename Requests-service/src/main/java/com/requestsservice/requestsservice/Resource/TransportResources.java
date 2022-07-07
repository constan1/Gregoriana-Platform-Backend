package com.requestsservice.requestsservice.Resource;

import com.requestsservice.requestsservice.Model.TransportRequests;
import com.requestsservice.requestsservice.Service.Services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/transportRequest/")
@RequiredArgsConstructor
public class TransportResources {


    private final CustomerService customerService;
    @GetMapping("public/{trackingNum}")
    @ResponseStatus(HttpStatus.OK)
    private TransportRequests getTransportRequestByTrackingNumber(@PathVariable(name = "trackingNum") String trackingNum){

        return customerService.getTransportRequestByTrackingNumber(trackingNum);

    }

}
