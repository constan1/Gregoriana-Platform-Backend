package com.RequestService.Request.Service.Resource;


import com.RequestService.Request.Service.Model.Consumers.TransportRequests;
import com.RequestService.Request.Service.Model.Transporters.PublicRequests;
import com.RequestService.Request.Service.Repository.TransporterRepository;
import com.RequestService.Request.Service.Service.Services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("/v1/request")
@RequiredArgsConstructor
public class CustomerResource {

    private final CustomerService customerService;
    private final TransporterRepository transporterRepository;


    @GetMapping("/customersRequest/{authID}")
    @ResponseStatus(HttpStatus.OK)
    private List<TransportRequests> getAllCustomersRequest(@PathVariable(name="authID") String authID){

        return customerService.getRequestForClient(authID);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private void requestCreated(@RequestBody TransportRequests request) throws NoSuchAlgorithmException {

        customerService.createRequest(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private List<PublicRequests> getRequestsForMarket(){
        return transporterRepository.findAll();
    }
}
