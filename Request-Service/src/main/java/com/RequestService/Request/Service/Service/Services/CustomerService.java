package com.RequestService.Request.Service.Service.Services;

import com.RequestService.Request.Service.Model.Consumers.ConsumersInquiries;
import com.RequestService.Request.Service.Model.Consumers.TransportRequests;
import com.RequestService.Request.Service.Model.Transporters.PublicRequests;
import com.RequestService.Request.Service.Model.Transporters.RequestHistory;
import com.RequestService.Request.Service.Model.Transporters.TransportInquiries;
import com.RequestService.Request.Service.Model.Transporters.TransportListing;
import org.springframework.data.repository.query.Param;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<TransportRequests> getRequestForClient(@Param("authID") String authID);

    List<PublicRequests> getRequestsForMarket();

    void createRequest(TransportRequests transportRequests) throws NoSuchAlgorithmException;

    void createTransportListing(TransportListing transportListing);

    void creatConsumerInquiry(ConsumersInquiries consumersInquiries);

    void transporterActiveInquiry(TransportInquiries transportInquiries);

    List<ConsumersInquiries> getAllInquiriesForTrackingNumber(String trackingNumber);

    List<TransportInquiries> getAllTransportInquiries(String email);

    List<TransportListing> getAllTransportListings();

    TransportListing getTransportersPersonalListing(String email);

    void deleteTransportRequest(Long id);

    void updateRequestStatus( String trackingNumber ,String status);

    void createRequestHistory(RequestHistory requestHistory);

    void deleteTransportInquiriesFromTrackingNum(String trackingNumber);

    PublicRequests selectedPublicRequest(String trackingNumber);
    
}
