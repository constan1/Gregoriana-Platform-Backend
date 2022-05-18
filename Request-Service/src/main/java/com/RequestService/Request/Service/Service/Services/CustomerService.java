package com.RequestService.Request.Service.Service.Services;

import com.RequestService.Request.Service.Model.Consumers.ConsumersInquiries;
import com.RequestService.Request.Service.Model.Consumers.privateRequest.TransportRequests;
import com.RequestService.Request.Service.Model.DTO.InquiriesDTO;
import com.RequestService.Request.Service.Model.Transporters.TransportInquiries;
import com.RequestService.Request.Service.Model.Transporters.TransportListing;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import java.util.List;

public interface CustomerService {

    List<TransportRequests> getRequestForClient(String authID);

    String createRequest(TransportRequests transportRequests) throws ObjectOptimisticLockingFailureException;

    String createTransportListing(TransportListing transportListing);

    String creatConsumerInquiry(InquiriesDTO inquiriesDTO);

    String transporterActiveInquiry(TransportInquiries transportInquiries);

    List<ConsumersInquiries> getAllInquiriesForTrackingNumber(String trackingNumber);

    List<TransportInquiries> getAllTransportInquiries(String email);

    List<TransportListing> getAllTransportListings();

    TransportListing getTransportersPersonalListing(String email);

    String deleteTransportRequest(String trackNum);

    String updateRequestStatus( String trackingNumber ,String status);

    String createRequestHistory(String trackingNumber, String signatureUrl)throws ObjectOptimisticLockingFailureException ;

    TransportRequests getTransportRequestByTrackingNumber(String trackNum);

    List<TransportRequests> getRequestForMarket(String pending);

    String deleteTransportListing(String email)throws ObjectOptimisticLockingFailureException;

    
}
