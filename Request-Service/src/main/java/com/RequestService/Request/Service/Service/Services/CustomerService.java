package com.RequestService.Request.Service.Service.Services;

import com.RequestService.Request.Service.Model.Consumers.ConsumersInquiries;
import com.RequestService.Request.Service.Model.Consumers.privateRequest.TransportRequests;
import com.RequestService.Request.Service.Model.DTO.InquiriesDTO;
import com.RequestService.Request.Service.Model.Transporters.RequestHistory;
import com.RequestService.Request.Service.Model.Transporters.TransportInquiries;
import com.RequestService.Request.Service.Model.Transporters.TransportListing;
import org.springframework.data.repository.query.Param;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface CustomerService {

    List<TransportRequests> getRequestForClient(String authID);

    void createRequest(TransportRequests transportRequests) throws NoSuchAlgorithmException;

    void createTransportListing(TransportListing transportListing);

    void creatConsumerInquiry(InquiriesDTO inquiriesDTO);

    void transporterActiveInquiry(TransportInquiries transportInquiries);

    List<ConsumersInquiries> getAllInquiriesForTrackingNumber(String trackingNumber);

    List<TransportInquiries> getAllTransportInquiries(String email);

    List<TransportListing> getAllTransportListings();

    TransportListing getTransportersPersonalListing(String email);

    void deleteTransportRequest(String trackNum);

    void updateRequestStatus( String trackingNumber ,String status);

    void createRequestHistory(RequestHistory requestHistory);

    TransportRequests getTransportRequestByTrackingNumber(String trackNum);

    List<TransportRequests> getRequestForMarket(String pending);

    void deleteTransportListing(String email);

    
}
