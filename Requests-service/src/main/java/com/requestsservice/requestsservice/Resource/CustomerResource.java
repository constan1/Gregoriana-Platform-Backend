package com.requestsservice.requestsservice.Resource;

import com.requestsservice.requestsservice.Model.TransportRequests;
import com.requestsservice.requestsservice.Service.Services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("/v1/supplierRequest/")
@RequiredArgsConstructor
public class CustomerResource {

    private final CustomerService customerService;


    @GetMapping("private/{authID}")
    @ResponseStatus(HttpStatus.OK)
    private List<TransportRequests> getAllCustomersRequest(@PathVariable(name="authID") String authID){

        return customerService.getRequestForClient(authID);
    }

    @PostMapping("private/create")
    @ResponseStatus(HttpStatus.CREATED)
    private String requestCreated(@RequestBody TransportRequests request) throws NoSuchAlgorithmException {

        return customerService.createRequest(request);
    }


    @DeleteMapping("private/{trackingNum}")
    @ResponseStatus(HttpStatus.OK)
    private void requestDeleted(@PathVariable(name = "trackingNum") String trackingNum){

        customerService.deleteTransportRequest(trackingNum);
    }



}
