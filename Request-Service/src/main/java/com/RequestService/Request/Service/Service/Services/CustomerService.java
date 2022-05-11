package com.RequestService.Request.Service.Service.Services;

import com.RequestService.Request.Service.Model.Consumers.TransportRequests;
import org.springframework.data.repository.query.Param;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface CustomerService {

    List<TransportRequests> getRequestForClient(@Param("authID") String authID);

    List<TransportRequests> getRequestsForMarket();

    void createRequest(TransportRequests transportRequests) throws NoSuchAlgorithmException;

}
