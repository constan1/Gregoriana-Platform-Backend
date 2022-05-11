package com.RequestService.Request.Service.Service.Implementation;


import com.RequestService.Request.Service.Hash.RequestReferenceHash;
import com.RequestService.Request.Service.Model.Consumers.TransportRequests;
import com.RequestService.Request.Service.Repository.CustomerRepository;
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

    @Override
    public List<TransportRequests> getRequestForClient(String authID) {
        return customerRepository.getRequestForClient(authID);
    }

    @Override
    public List<TransportRequests> getRequestsForMarket() {
       return customerRepository.findAll();
    }

    @Override
    public void createRequest(TransportRequests transportRequests) throws NoSuchAlgorithmException {

        Timestamp ts = new Timestamp(System.currentTimeMillis());
        Date date = new Date(ts.getTime());
        transportRequests.setDateStamp(date);
        transportRequests.setTrackingNumber(RequestReferenceHash.createMD5Hash(
                transportRequests.getAuthID()+transportRequests.getDateStamp()));

        customerRepository.save(transportRequests);
    }
}
