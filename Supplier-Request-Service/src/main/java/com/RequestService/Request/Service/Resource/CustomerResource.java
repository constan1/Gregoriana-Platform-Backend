package com.RequestService.Request.Service.Resource;


import com.RequestService.Request.Service.Model.Consumers.privateRequest.TransportRequests;
import com.RequestService.Request.Service.Service.Services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class CustomerResource {

    private final CustomerService customerService;


    @GetMapping("/supplier-request/customersRequest/{authID}")
    @ResponseStatus(HttpStatus.OK)
    private List<TransportRequests> getAllCustomersRequest(@PathVariable(name="authID") String authID){

        return customerService.getRequestForClient(authID);
    }

    @PostMapping("/supplier-request/create")
    @ResponseStatus(HttpStatus.CREATED)
    private String requestCreated(@RequestBody TransportRequests request) throws NoSuchAlgorithmException {

        return customerService.createRequest(request);
    }


    @DeleteMapping("/supplier-request/{trackingNum}")
    @ResponseStatus(HttpStatus.OK)
    private void requestDeleted(@PathVariable(name = "trackingNum") String trackingNum){

        customerService.deleteTransportRequest(trackingNum);
    }





}