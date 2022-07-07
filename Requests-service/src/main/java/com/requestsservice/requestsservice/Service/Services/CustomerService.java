package com.requestsservice.requestsservice.Service.Services;

import com.requestsservice.requestsservice.Model.TransportRequests;
import org.springframework.orm.ObjectOptimisticLockingFailureException;

import java.util.List;

public interface CustomerService {


    List<TransportRequests> getRequestForClient(String authID);

    String createRequest(TransportRequests transportRequests) throws ObjectOptimisticLockingFailureException;

    void deleteTransportRequest(String trackNum);

    TransportRequests getTransportRequestByTrackingNumber(String trackNum);

}
