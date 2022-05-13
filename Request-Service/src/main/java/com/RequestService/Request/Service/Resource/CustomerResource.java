package com.RequestService.Request.Service.Resource;


import com.RequestService.Request.Service.Model.Consumers.ConsumersInquiries;
import com.RequestService.Request.Service.Model.Consumers.TransportRequests;
import com.RequestService.Request.Service.Model.DTO.RequestStatusDTO;
import com.RequestService.Request.Service.Model.Transporters.PublicRequests;
import com.RequestService.Request.Service.Model.Transporters.RequestHistory;
import com.RequestService.Request.Service.Model.Transporters.TransportInquiries;
import com.RequestService.Request.Service.Model.Transporters.TransportListing;
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
        return customerService.getRequestsForMarket();
    }

    @PostMapping("/consumerInquiries")
    @ResponseStatus(HttpStatus.OK)
    private void createInquiries(@RequestBody ConsumersInquiries consumersInquiries){

        customerService.creatConsumerInquiry(consumersInquiries);

    }

    @PostMapping("/transporterActiveInquiries")
    @ResponseStatus(HttpStatus.OK)
    private void createTransporterActiveInquiries(@RequestBody TransportInquiries transportInquiries)
    {
        customerService.transporterActiveInquiry(transportInquiries);
    }

    @PostMapping("/createTransportListing")
    @ResponseStatus(HttpStatus.OK)
    private void createTransportListing(@RequestBody TransportListing transportListing){
        customerService.createTransportListing(transportListing);
    }

    @GetMapping("/consumersInquiries/{trackingNumber}")
    @ResponseStatus(HttpStatus.OK)
    private List<ConsumersInquiries> getAllInquiries(@PathVariable("trackingNumber") String trackingNumber){

        return customerService.getAllInquiriesForTrackingNumber(trackingNumber);
    }

    @GetMapping("/TransportInquiries/{emailID}")
    @ResponseStatus(HttpStatus.OK)
    private List<TransportInquiries> getTransportInquiries(@PathVariable("emailID") String email){

        return customerService.getAllTransportInquiries(email);
    }

    @GetMapping("/TransportListings")
    @ResponseStatus(HttpStatus.OK)
    private List<TransportListing> getAllTransportListing(){
        return customerService.getAllTransportListings();
    }

    @GetMapping("/TransportListing/{emailID}")
    @ResponseStatus(HttpStatus.OK)
    private TransportListing getTransportListing(@PathVariable("emailID") String email){
        return customerService.getTransportersPersonalListing(email);
    }

    @GetMapping("/PublicRequest/{trackingNumber}")
    @ResponseStatus(HttpStatus.OK)
    private PublicRequests getPublicRequest(@PathVariable("trackingNumber") String trackingNumber){
       return customerService.selectedPublicRequest(trackingNumber);
    }

    @DeleteMapping("/deleteTransportRequest/{id}")
    @ResponseStatus(HttpStatus.OK)
    private void deleteTransportRequest(@PathVariable("id") Long id){
        customerService.deleteTransportRequest(id);
    }

    @DeleteMapping("/deleteTransportInquiry{trackingNumber}")
    @ResponseStatus(HttpStatus.OK)
    private void deleteTransportInquiry(@PathVariable("trackingNumber") String trackingNumber){
        customerService.deleteTransportInquiriesFromTrackingNum(trackingNumber);
    }

    @PutMapping("/updateRequestStatus")
    @ResponseStatus(HttpStatus.OK)
    private void updateRequestStatus(@RequestBody RequestStatusDTO requestStatusDTO){
        customerService.updateRequestStatus(requestStatusDTO.getTrackingNumber(),requestStatusDTO.getStatus());
    }

    @PostMapping("/requestCompleted")
    @ResponseStatus(HttpStatus.OK)
    private void requestCompleted(@RequestBody RequestHistory requestHistory){
        customerService.createRequestHistory(requestHistory);
    }


}
