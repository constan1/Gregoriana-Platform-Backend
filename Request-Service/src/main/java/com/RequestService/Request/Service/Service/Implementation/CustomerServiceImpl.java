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
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;
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
    public String deleteTransportListing(String email) throws ObjectOptimisticLockingFailureException{

        //Optimistic locking

        try {

            Optional<TransportListing> transportListing_ = Optional.ofNullable(transporterListingRepository.getTransportersListing(email));

            transportListing_.ifPresent(transporterListingRepository::delete);


        }catch (Exception e){
            return e.getMessage();
        }

        return "Success";
    }

    @Override
    public String createRequest(TransportRequests transportRequests) throws ObjectOptimisticLockingFailureException{


        try {


            String entropyTrNum = entropy.getEntropy_();

            Optional<TransportRequests> transportRequestsNum = Optional.ofNullable(customerRepository.getTransportRequestByTrackingNumber(entropyTrNum));

            if (transportRequestsNum.isEmpty()) {

                Timestamp ts = new Timestamp(System.currentTimeMillis());
                Date date = new Date(ts.getTime());
                transportRequests.setDateStamp(date);
                transportRequests.setTrackingNumber(entropyTrNum);
                transportRequests.setStatus("pending");
                customerRepository.save(transportRequests);
            }
        } catch (Exception e){
            return e.getMessage();
        }

        return "Success";
    }

    @Override
    public String createTransportListing(TransportListing transportListing)throws ObjectOptimisticLockingFailureException {

        try {


            transporterListingRepository.save(transportListing);
        } catch (Exception e){
            return e.getMessage();
        }

        return "Success";
    }

    @Override
    public String creatConsumerInquiry(InquiriesDTO inquiriesDTO) throws ObjectOptimisticLockingFailureException{


        try {

            Optional<TransportListing> TransportListing = Optional.ofNullable(transporterListingRepository.getTransportersListing(inquiriesDTO.getEmail()));

            Optional<TransportRequests> transportRequests = Optional.ofNullable(customerRepository.getTransportRequestByTrackingNumber(inquiriesDTO.getTrackingNum()));

            //check whether request hasn't been updated to "active"
            if (TransportListing.isPresent() && transportRequests.isPresent()) {
                if (Objects.equals(transportRequests.get().getStatus(), "pending")) {
                    ConsumersInquiries consumersInquiries = new ConsumersInquiries();
                    consumersInquiries.setTrackingNumber(inquiriesDTO.getTrackingNum());
                    consumersInquiries.setTransportListing(TransportListing.get());
                    consumerInquiryRepository.save(consumersInquiries);
                }
            }
            else {
                return "Failed To Create Customer Inquiry";
            }
        }catch (Exception e){
            return e.getMessage();
        }
        return "Success";
    }

    @Override
    public String transporterActiveInquiry(TransportInquiries transportInquiries) throws ObjectOptimisticLockingFailureException{

        try {
            Optional<TransportRequests> transportRequests = Optional.ofNullable(customerRepository.getTransportRequestByTrackingNumber(transportInquiries.getReferenceTrackingNumber()));

            Optional<TransportListing> transportListing_ = Optional.ofNullable(transporterListingRepository.getTransportersListing(transportInquiries.getEmail()));


            if (transportRequests.isPresent() && transportListing_.isPresent()) {
                customerRepository.updateRequestStatus(transportInquiries.getReferenceTrackingNumber(), "Active");
                transportInquiriesRepository.save(transportInquiries);
            }
        } catch (Exception e){
            return e.getMessage();
        }
        return "Success";
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
    public String  deleteTransportRequest(String trackNum) throws ObjectOptimisticLockingFailureException{


        //Optimistic locking

        try {
            Optional<TransportRequests> transportRequests = Optional.ofNullable(customerRepository.getTransportRequestByTrackingNumber(trackNum));
            Optional<ConsumersInquiries> consumersInquiries = Optional.ofNullable(consumerInquiryRepository.getConsumerInquiry(trackNum));

            transportRequests.ifPresent(customerRepository::delete);

            if (consumersInquiries.isPresent()) {
                consumerInquiryRepository.deleteConsumerInquiryByTrNum(trackNum);
            }
        } catch (Exception e){
            return e.getMessage();
        }

        return "Success";
    }

    @Override
    public String updateRequestStatus(String trackingNumber, String status) throws ObjectOptimisticLockingFailureException{
        //check whether request exists before updating status.


        try {
            Optional<TransportRequests> transportRequests = Optional.ofNullable(customerRepository.getTransportRequestByTrackingNumber(trackingNumber));

            if (transportRequests.isPresent()) {
                customerRepository.updateRequestStatus(trackingNumber, status);
            }
        } catch (Exception e){
            return e.getMessage();
        }

        return "Success";

    }

    @Override
    public String createRequestHistory(RequestHistory requestHistory) throws ObjectOptimisticLockingFailureException {


        try {

            Optional<TransportInquiries> transportInquiries = Optional.ofNullable(transportInquiriesRepository.getTrackingInquiry(requestHistory.getTransportRequests().getTrackingNumber()));
            Optional<TransportRequests> transportRequests = Optional.ofNullable(customerRepository.getTransportRequestByTrackingNumber(requestHistory.getTransportRequests().getTrackingNumber()));
            Optional<ConsumersInquiries> consumersInquiries = Optional.ofNullable(consumerInquiryRepository.getConsumerInquiry(requestHistory.getTransportRequests().getTrackingNumber()));


            //After customer signs for items.

            //Optimistic Locking

            Timestamp ts = new Timestamp(System.currentTimeMillis());
            Date date = new Date(ts.getTime());

            requestHistory.setDateOfCompletion(date);

            if (transportInquiries.isPresent()) {
                transportRequests.ifPresent(customerRepository::delete);
                transportInquiriesRepository.deleteTransportInquiriesFromTrackingNum(requestHistory.getTransportRequests().getTrackingNumber());
                consumersInquiries.ifPresent(consumerInquiryRepository::delete);
                requestDeliveredRepository.save(requestHistory);
            }
        }catch (Exception e){

            return e.getMessage();
        }
       return "Success";
    }


}
