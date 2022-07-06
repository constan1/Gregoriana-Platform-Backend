package com.RequestService.Request.Service.Service.Implementation;


import com.RequestService.Request.Service.Model.Consumers.privateRequest.TransportRequests;
import com.RequestService.Request.Service.QuantumEntropy.entropy;
import com.RequestService.Request.Service.Repository.*;
import com.RequestService.Request.Service.Service.Services.CustomerService;
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
    public void deleteTransportRequest(String trackNum) {
        Optional<TransportRequests> transportRequests = Optional.ofNullable(customerRepository.getTransportRequestByTrackingNumber(trackNum));

        transportRequests.ifPresent(customerRepository::delete);
    }

    @Override
    public TransportRequests getTransportRequestByTrackingNumber(String trackNum) {
        Optional<TransportRequests> transportRequests = Optional.ofNullable(customerRepository.getTransportRequestByTrackingNumber(trackNum));

        return transportRequests.orElseGet(transportRequests::get);

    }


}
