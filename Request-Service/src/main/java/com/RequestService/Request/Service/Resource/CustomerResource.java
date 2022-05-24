package com.RequestService.Request.Service.Resource;


import com.RequestService.Request.Service.Model.Consumers.ConsumersInquiries;
import com.RequestService.Request.Service.Model.Consumers.privateRequest.TransportRequests;
import com.RequestService.Request.Service.Model.DTO.InquiriesDTO;
import com.RequestService.Request.Service.Model.DTO.RequestCompletedDTO;
import com.RequestService.Request.Service.Model.DTO.RequestStatusDTO;
import com.RequestService.Request.Service.Model.Transporters.TransportInquiries;
import com.RequestService.Request.Service.Model.Transporters.TransportListing;
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


    @GetMapping("/customer-request/customersRequest/{authID}")
    @ResponseStatus(HttpStatus.OK)
    private List<TransportRequests> getAllCustomersRequest(@PathVariable(name="authID") String authID){

        return customerService.getRequestForClient(authID);
    }

    @PostMapping("/customer-request/create")
    @ResponseStatus(HttpStatus.CREATED)
    private String requestCreated(@RequestBody TransportRequests request) throws NoSuchAlgorithmException {

        return customerService.createRequest(request);
    }

    @GetMapping("/transporter-request/getAllRequests")
    @ResponseStatus(HttpStatus.OK)
    private List<TransportRequests> getRequestsForMarket(){
        return customerService.getRequestForMarket("pending");
    }

    @PostMapping("/transporter-request/consumerInquiries")
    @ResponseStatus(HttpStatus.OK)
    private String createInquiries(@RequestBody InquiriesDTO inquiriesDTO){

        return customerService.creatConsumerInquiry(inquiriesDTO);

    }

    @PostMapping("/transporter-request/transporterActiveInquiries")
    @ResponseStatus(HttpStatus.OK)
    private String createTransporterActiveInquiries(@RequestBody TransportInquiries transportInquiries)
    {
        return customerService.transporterActiveInquiry(transportInquiries);
    }

    @PostMapping("/transporter-request/createTransportListing")
    @ResponseStatus(HttpStatus.OK)
    private String createTransportListing(@RequestBody TransportListing transportListing){
        return customerService.createTransportListing(transportListing);
    }

    @GetMapping("/customer-request/consumersInquiries/{trackingNumber}")
    @ResponseStatus(HttpStatus.OK)
    private List<ConsumersInquiries> getAllInquiries(@PathVariable("trackingNumber") String trackingNumber){

        return customerService.getAllInquiriesForTrackingNumber(trackingNumber);
    }

    @GetMapping("/transporter-request/TransportInquiries/{emailID}")
    @ResponseStatus(HttpStatus.OK)
    private List<TransportInquiries> getTransportInquiries(@PathVariable("emailID") String email){

        return customerService.getAllTransportInquiries(email);
    }

    @GetMapping("/customer-request/TransportListings")
    @ResponseStatus(HttpStatus.OK)
    private List<TransportListing> getAllTransportListing(){
        return customerService.getAllTransportListings();
    }

    @GetMapping("/customer-request/TransportListing/{emailID}")
    @ResponseStatus(HttpStatus.OK)
    private TransportListing getTransportListingPublic(@PathVariable("emailID") String email){
        return customerService.getTransportersPersonalListing(email);
    }

    @GetMapping("/transporter-request/TransportListing/{emailID}")
    @ResponseStatus(HttpStatus.OK)
    private TransportListing getTransportListingPrivate(@PathVariable("emailID") String email){
        return customerService.getTransportersPersonalListing(email);
    }

    @DeleteMapping("/transporter-request/removeTransportListing/{emailID}")
    @ResponseStatus(HttpStatus.OK)
    private String deleteTransportListing(@PathVariable("emailID") String emailID){
        return customerService.deleteTransportListing(emailID);
    }

    @GetMapping("/transporter-request/PublicRequest/{trackingNumber}")
    @ResponseStatus(HttpStatus.OK)
    private TransportRequests getPublicRequest(@PathVariable("trackingNumber") String trackingNumber){
       return customerService.getTransportRequestByTrackingNumber(trackingNumber);
    }

    @DeleteMapping("/customer-request/deleteTransportRequest/{trackingNum}")
    @ResponseStatus(HttpStatus.OK)
    private String deleteTransportRequest(@PathVariable("trackingNum") String trackingNum){
        return customerService.deleteTransportRequest(trackingNum);
    }



    @PutMapping("/customer-request/updateRequestStatus")
    @ResponseStatus(HttpStatus.OK)
    private String updateRequestStatus(@RequestBody RequestStatusDTO requestStatusDTO){
        return customerService.updateRequestStatus(requestStatusDTO.getTrackingNumber(),requestStatusDTO.getStatus());
    }

    @PostMapping("/customer-request/requestCompleted")
    @ResponseStatus(HttpStatus.OK)
    private String requestCompleted(@RequestBody RequestCompletedDTO requestHistory){
       return  customerService.createRequestHistory(requestHistory.getTrackingNumber(), requestHistory.getSignatureUrl());
    }




}
