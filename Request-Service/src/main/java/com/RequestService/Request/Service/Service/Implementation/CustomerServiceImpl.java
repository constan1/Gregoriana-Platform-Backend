package com.RequestService.Request.Service.Service.Implementation;


import com.RequestService.Request.Service.Model.Consumers.ConsumersInquiries;
import com.RequestService.Request.Service.Model.Consumers.privateRequest.TransportRequests;
import com.RequestService.Request.Service.Model.DTO.InquiriesDTO;
import com.RequestService.Request.Service.Model.LoggingService.RequestHistory;
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

            if(transportListing_.isPresent()){

                consumerInquiryRepository.deleteConsumersInquiriesByEmail(email);
                transporterListingRepository.delete(transportListing_.get());

                return "Success: Your listing has been deleted as well as your inquiries.Customers will not see your listing on any " +
                        "active or pending orders";

            }
            else {
                return "Failed: This listing has already been deleted or does not exist";
            }


        }catch (Exception e){
            return e.getMessage();
        }

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

            Optional<TransportListing> transportListing_ = Optional.ofNullable(transporterListingRepository.getTransportersListing(transportListing.getEmail()));

            if(transportListing_.isEmpty()){
                transporterListingRepository.save(transportListing);
                return "Success";
            }

            else {
                return "Transport Listing already exists.";
            }


        } catch (Exception e){
            return e.getMessage();
        }

    }

    @Override
    public String creatConsumerInquiry(InquiriesDTO inquiriesDTO) throws ObjectOptimisticLockingFailureException{


        try {

            Optional<TransportListing> TransportListing = Optional.ofNullable(transporterListingRepository.getTransportersListing(inquiriesDTO.getEmail()));

            Optional<TransportRequests> transportRequests = Optional.ofNullable(customerRepository.getTransportRequestByTrackingNumber(inquiriesDTO.getTrackingNum()));

            Optional<ConsumersInquiries> consumersInquiries_ = Optional.ofNullable(consumerInquiryRepository.checkConsumerInquiry(inquiriesDTO.getTrackingNum(),inquiriesDTO.getEmail()));



            //check whether request hasn't been updated to "active"
            if (TransportListing.isPresent() && transportRequests.isPresent()) {
                if (Objects.equals(transportRequests.get().getStatus(), "pending") && consumersInquiries_.isEmpty()) {
                    Timestamp ts = new Timestamp(System.currentTimeMillis());
                    Date date = new Date(ts.getTime());
                    ConsumersInquiries consumersInquiries = new ConsumersInquiries();
                    consumersInquiries.setTrackingNumber(inquiriesDTO.getTrackingNum());
                    consumersInquiries.setTransportListing(TransportListing.get());
                    consumersInquiries.setDateTimeStamp(date);
                    consumerInquiryRepository.save(consumersInquiries);
                }
                else {
                    return "Error: This request is already active or you have already inquired on it.";
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

            Optional<ConsumersInquiries> consumersInquiries = Optional.ofNullable(consumerInquiryRepository.checkConsumerInquiry(transportInquiries.getReferenceTrackingNumber(),transportInquiries.getEmail()));
            //check whether this inquiry already exists

            if (transportRequests.isPresent() && transportListing_.isPresent() && Objects.equals(transportRequests.get().getStatus(), "pending") && consumersInquiries.isPresent()) {
                customerRepository.updateRequestStatus(transportInquiries.getReferenceTrackingNumber(), "Active");
                transportInquiriesRepository.save(transportInquiries);
                return "Order active: Transporter notified";
            }
            else {
                return "Order Not Activated:";
            }
        } catch (Exception e){
            return e.getMessage();
        }
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
        return transporterListingRepository.getAllTransportListing();
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

            if(transportRequests.isPresent()){
                customerRepository.delete(transportRequests.get());
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
    public String createRequestHistory(String trackingNumber, String signatureUrl) throws ObjectOptimisticLockingFailureException {


        try {

            Optional<TransportInquiries> transportInquiries = Optional.ofNullable(transportInquiriesRepository.getTrackingInquiry(trackingNumber));
            Optional<TransportRequests> transportRequests = Optional.ofNullable(customerRepository.getTransportRequestByTrackingNumber(trackingNumber));


            //After customer signs for items.

            //Optimistic Locking

            if (transportInquiries.isPresent() && transportRequests.isPresent()) {

                Timestamp ts = new Timestamp(System.currentTimeMillis());
                Date date = new Date(ts.getTime());

                RequestHistory requestHistory = new RequestHistory();

                requestHistory.setDateOfCompletion(date);
                requestHistory.setTransportRequests(transportRequests.get());
                requestHistory.setSignatureUrl(signatureUrl);

                customerRepository.delete(transportRequests.get());
                transportInquiriesRepository.deleteTransportInquiriesFromTrackingNum(trackingNumber);
                consumerInquiryRepository.deleteConsumerInquiryByTrNum(trackingNumber);


                // Pass the Request-History entity to Logging-Service - Circuit Breakers.

                //Send this entity to the logging-service;

                return "Success: Request Persisted";
            }
            else{
                return "Error: Transaction history not persisted";
            }
        }catch (Exception e){

            return e.getMessage();
        }
    }


}
