package com.RequestService.Request.Service.Service.Implementation;


import com.RequestService.Request.Service.Model.Consumers.ConsumersInquiries;
import com.RequestService.Request.Service.Model.Consumers.privateRequest.TransportRequests;
import com.RequestService.Request.Service.Model.DTO.InquiriesDTO;
import com.RequestService.Request.Service.Model.Transporters.RequestHistory;
import com.RequestService.Request.Service.Model.Transporters.TransportInquiries;
import com.RequestService.Request.Service.Model.Transporters.TransportListing;
import com.RequestService.Request.Service.QuantumEntropy.entropy;
import com.RequestService.Request.Service.Repository.*;
import com.RequestService.Request.Service.Service.Services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


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
    public void deleteTransportListing(String email) {

        Optional<TransportListing> transportListing_ = Optional.ofNullable(transporterListingRepository.getTransportersListing(email));

        transportListing_.ifPresent(transporterListingRepository::delete);
    }

    @Override
    public void createRequest(TransportRequests transportRequests) {

       String entropyTrNum= entropy.getEntropy_();

        Optional<TransportRequests>  transportRequestsNum = Optional.ofNullable(customerRepository.getTransportRequestByTrackingNumber(entropyTrNum));

        if(transportRequestsNum.isEmpty()) {

            Timestamp ts = new Timestamp(System.currentTimeMillis());
            Date date = new Date(ts.getTime());
            transportRequests.setDateStamp(date);
            transportRequests.setTrackingNumber(entropyTrNum);
            transportRequests.setStatus("pending");
            customerRepository.save(transportRequests);
        }
    }

    @Override
    public void createTransportListing(TransportListing transportListing) {

        transporterListingRepository.save(transportListing);
    }

    @Override
    public void creatConsumerInquiry(InquiriesDTO inquiriesDTO) {

        Optional<TransportListing> TransportListing = Optional.ofNullable(transporterListingRepository.getTransportersListing(inquiriesDTO.getEmail()));

        if(TransportListing.isPresent()){
            ConsumersInquiries consumersInquiries = new ConsumersInquiries();
            consumersInquiries.setTrackingNumber(inquiriesDTO.getTrackingNum());
            consumersInquiries.setTransportListing(TransportListing.get());

            consumerInquiryRepository.save(consumersInquiries);
        }
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
        //check whether request exists before updating status.

        Optional<TransportRequests> transportRequests = Optional.ofNullable(customerRepository.getTransportRequestByTrackingNumber(trackingNumber));

        if(transportRequests.isPresent()){
            customerRepository.updateRequestStatus(trackingNumber,status);
        }

    }

    @Override
    public void createRequestHistory(RequestHistory requestHistory) {

        Optional<TransportInquiries> transportInquiries = Optional.ofNullable(transportInquiriesRepository.getTrackingInquiry(requestHistory.getTransportRequests().getTrackingNumber()));
        Optional<TransportRequests>  transportRequests = Optional.ofNullable(customerRepository.getTransportRequestByTrackingNumber(requestHistory.getTransportRequests().getTrackingNumber()));
        Optional<ConsumersInquiries> consumersInquiries = Optional.ofNullable(consumerInquiryRepository.getConsumerInquiry(requestHistory.getTransportRequests().getTrackingNumber()));


        //After customer signs for items.

        Timestamp ts = new Timestamp(System.currentTimeMillis());
        Date date = new Date(ts.getTime());

        requestHistory.setDateOfCompletion(date);

        if(transportInquiries.isPresent()){
            transportRequests.ifPresent(customerRepository::delete); transportRequests.ifPresent(customerRepository::delete);
            transportInquiriesRepository.deleteTransportInquiriesFromTrackingNum(requestHistory.getTransportRequests().getTrackingNumber());
            consumersInquiries.ifPresent(consumerInquiryRepository::delete);
            requestDeliveredRepository.save(requestHistory);
        }

    }


}
