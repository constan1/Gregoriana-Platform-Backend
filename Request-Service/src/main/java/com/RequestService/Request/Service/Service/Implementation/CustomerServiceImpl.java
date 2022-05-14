package com.RequestService.Request.Service.Service.Implementation;


import com.RequestService.Request.Service.Model.Consumers.ConsumersInquiries;
import com.RequestService.Request.Service.Model.Consumers.privateRequest.TransportRequests;
import com.RequestService.Request.Service.Model.Transporters.RequestHistory;
import com.RequestService.Request.Service.Model.Transporters.TransportInquiries;
import com.RequestService.Request.Service.Model.Transporters.TransportListing;
import com.RequestService.Request.Service.QuantumEntropy.entropy;
import com.RequestService.Request.Service.Repository.*;
import com.RequestService.Request.Service.Service.Services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {


    private  final CustomerRepository customerRepository;
    private final TransporterListingRepository transporterListingRepository;
    private final ConsumerInquiryRepository consumerInquiryRepository;
    private final TransportInquiriesRepository transportInquiriesRepository;
    private final RequestDeliveredRepository requestDeliveredRepository;


    @Override
    public List<TransportRequests> getRequestForClient(String authID) {
        return customerRepository.getRequestForClient(authID);
    }


    @Override
    public TransportRequests getTransportRequestByTrackingNumber(String trackNum) {
        return customerRepository.getTransportRequestByTrackingNumber(trackNum);
    }

    @Override
    public List<TransportRequests> getRequestForMarket(String pending) {
        return customerRepository.getRequestForMarket(pending);
    }

    @Override
    public void createRequest(TransportRequests transportRequests) {

        Timestamp ts = new Timestamp(System.currentTimeMillis());
        Date date = new Date(ts.getTime());
        transportRequests.setDateStamp(date);
        transportRequests.setTrackingNumber(entropy.getEntropy_());
        transportRequests.setStatus("pending");

        //Check if tracking number exists before creating the request.

        customerRepository.save(transportRequests);

    }

    @Override
    public void createTransportListing(TransportListing transportListing) {


        transporterListingRepository.save(transportListing);
    }

    @Override
    public void creatConsumerInquiry(ConsumersInquiries consumersInquiries) {


        consumerInquiryRepository.save(consumersInquiries);
    }

    @Override
    public void transporterActiveInquiry(TransportInquiries transportInquiries) {
        transportInquiriesRepository.save(transportInquiries);
    }

    @Override
    public List<ConsumersInquiries> getAllInquiriesForTrackingNumber(String trackingNumber) {
        return consumerInquiryRepository.getAllInquiriesForTrackingNumber(trackingNumber);
    }

    @Override
    public List<TransportInquiries> getAllTransportInquiries(String email) {

        return transportInquiriesRepository.getAllTransportInquiries(email);
    }

    @Override
    public List<TransportListing> getAllTransportListings() {
        return transporterListingRepository.findAll();
    }

    @Override
    public TransportListing getTransportersPersonalListing(String email) {
        return transporterListingRepository.getTransportersListing(email);
    }

    @Override
    public void deleteTransportRequest(String trackNum) {

        Optional<TransportRequests>  transportRequests = Optional.ofNullable(customerRepository.getTransportRequestByTrackingNumber(trackNum));
        Optional<ConsumersInquiries> consumersInquiries = Optional.ofNullable(consumerInquiryRepository.getConsumerInquiry(trackNum));


        transportRequests.ifPresent(customerRepository::delete);

        if(consumersInquiries.isPresent()){
            consumerInquiryRepository.deleteConsumerInquiryByTrNum(trackNum);
        }


    }

    @Override
    public void updateRequestStatus(String trackingNumber, String status) {
        customerRepository.updateRequestStatus(trackingNumber,status);
    }

    @Override
    public void createRequestHistory(RequestHistory requestHistory) {

        Optional<TransportInquiries> transportInquiries = Optional.ofNullable(transportInquiriesRepository.getTrackingInquiry(requestHistory.getTransportRequests().getTrackingNumber()));
        Optional<TransportRequests>  transportRequests = Optional.ofNullable(customerRepository.getTransportRequestByTrackingNumber(requestHistory.getTransportRequests().getTrackingNumber()));

        //After customer signs for items.

        Timestamp ts = new Timestamp(System.currentTimeMillis());
        Date date = new Date(ts.getTime());

        requestHistory.setDateOfCompletion(date);

        if(transportInquiries.isPresent()){
            transportInquiriesRepository.deleteTransportInquiriesFromTrackingNum(requestHistory.getTransportRequests().getTrackingNumber());
            transportRequests.ifPresent(customerRepository::delete);
            requestDeliveredRepository.save(requestHistory);
        }

    }


}
