package com.requestsservice.requestsservice.Service.Implementation;

import com.requestsservice.requestsservice.Model.DTO.publicTransportRequestsDTO;
import com.requestsservice.requestsservice.Model.TransportRequests;
import com.requestsservice.requestsservice.QuantumEntropy.entropy;
import com.requestsservice.requestsservice.Repository.CustomerRepository;
import com.requestsservice.requestsservice.Service.Services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {


    private final CustomerRepository customerRepository;



    @Override
    public List<TransportRequests> getRequestForClient(String authID) {
        return customerRepository.getRequestForClient(authID);
    }

    //return transport request obejct instead of string after successful database insertion.
    @Override
    public String createRequest(TransportRequests transportRequests) throws ObjectOptimisticLockingFailureException {

        String returnTRackingNum;

        try {


            String entropyTrNum = entropy.getEntropy_();
            returnTRackingNum = entropyTrNum;

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

        return returnTRackingNum;


    }

    @Override
    public void deleteTransportRequest(String trackNum) {
        Optional<TransportRequests> transportRequests = Optional.ofNullable(customerRepository.getTransportRequestByTrackingNumber(trackNum));

        transportRequests.ifPresent(customerRepository::delete);
    }

    @Override
    public publicTransportRequestsDTO getTransportRequestByTrackingNumber(String trackNum) {
        Optional<TransportRequests> transportRequests = Optional.ofNullable(customerRepository.getTransportRequestByTrackingNumber(trackNum));

        publicTransportRequestsDTO publicRequests = new publicTransportRequestsDTO();

        if(transportRequests.isPresent()){
            publicRequests.setTitle(transportRequests.get().getTitle());
            publicRequests.setTrackingNumber(transportRequests.get().getTrackingNumber());
            publicRequests.setDateStamp(transportRequests.get().getDateStamp());
            publicRequests.setStops(transportRequests.get().getStops());
            publicRequests.setDesired_time_arrival(transportRequests.get().getDesired_time_arrival());
            publicRequests.setAddOn(transportRequests.get().getAddOn());
            publicRequests.setVehicleTypeNeeded(transportRequests.get().getVehicleTypeNeeded());
            return publicRequests;
        }
        return  null;
    }

}
