package com.RequestService.Request.Service.Service.Implementation;


import com.RequestService.Request.Service.QuantumEntropy.RequestReferenceHash;
import com.RequestService.Request.Service.Model.Consumers.ConsumersInquiries;
import com.RequestService.Request.Service.Model.Consumers.TransportRequests;
import com.RequestService.Request.Service.Model.Transporters.PublicRequests;
import com.RequestService.Request.Service.Model.Transporters.RequestHistory;
import com.RequestService.Request.Service.Model.Transporters.TransportInquiries;
import com.RequestService.Request.Service.Model.Transporters.TransportListing;
import com.RequestService.Request.Service.Repository.*;
import com.RequestService.Request.Service.Service.Services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {


    private  final CustomerRepository customerRepository;
    private final PublicRequestsRepository publicRequestsRepository;
    private final TransporterListingRepository transporterListingRepository;
    private final ConsumerInquiryRepository consumerInquiryRepository;
    private final TransportInquiriesRepository transportInquiriesRepository;
    private final RequestDeliveredRepository requestDeliveredRepository;
    private final AddOnRepository addOnRepository;
    private final StopsRepository stopsRepository;
    private final DropOffRepository dropOffRepository;

    @Override
    public List<TransportRequests> getRequestForClient(String authID) {
        return customerRepository.getRequestForClient(authID);
    }

    @Override
    public List<PublicRequests> getRequestsForMarket() {

        return publicRequestsRepository.findAll();
    }

    @Override
    public void createRequest(TransportRequests transportRequests) throws NoSuchAlgorithmException {

        Timestamp ts = new Timestamp(System.currentTimeMillis());
        Date date = new Date(ts.getTime());
        transportRequests.setDateStamp(date);
        transportRequests.setTrackingNumber(RequestReferenceHash.createMD5Hash(
                transportRequests.getAuthID()+transportRequests.getDateStamp()));
        PublicRequests transportPublic = new PublicRequests();

        transportPublic.setTitle(transportRequests.getTitle());
        transportPublic.setDateStamp(transportRequests.getDateStamp());
        transportPublic.setDesired_time_arrival(transportRequests.getDesired_time_arrival());
        transportPublic.setStops(transportRequests.getStops());
        transportPublic.setAddOn(transportRequests.getAddOn());
        transportPublic.setTrackingNumber(transportRequests.getTrackingNumber());

        customerRepository.save(transportRequests);
        publicRequestsRepository.save(transportPublic);
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
    public void deleteTransportRequest(Long id) {
        customerRepository.deleteTransportRequest(id);
        dropOffRepository.deleteOffs(id);
        addOnRepository.deleteAddOn(id);
        stopsRepository.deleteStops(id);


        publicRequestsRepository.deletePublicRequest(id);
    }




    @Override
    public void updateRequestStatus(String trackingNumber, String status) {
        customerRepository.updateRequestStatus(trackingNumber,status);
    }

    @Override
    public void createRequestHistory(RequestHistory requestHistory) {

        Timestamp ts = new Timestamp(System.currentTimeMillis());
        Date date = new Date(ts.getTime());

        requestHistory.setDateOfCompletion(date);

        transportInquiriesRepository.deleteTransportInquiriesFromTrackingNum(requestHistory.getTrackingNumber());
        requestDeliveredRepository.save(requestHistory);
    }

    @Override
    public void deleteTransportInquiriesFromTrackingNum(String trackingNumber) {
        transportInquiriesRepository.deleteTransportInquiriesFromTrackingNum(trackingNumber);
        consumerInquiryRepository.deleteConsumerInquiryByTrNum(trackingNumber);
    }

    @Override
    public PublicRequests selectedPublicRequest(String trackingNumber) {
        return publicRequestsRepository.selectedPublicRequest(trackingNumber);
    }

}
