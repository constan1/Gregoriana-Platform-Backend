package com.RequestService.Request.Service.Service.Services;

import com.RequestService.Request.Service.Model.Consumers.privateRequest.TransportRequests;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import java.util.List;

public interface CustomerService {

    List<TransportRequests> getRequestForClient(String authID);

    String createRequest(TransportRequests transportRequests) throws ObjectOptimisticLockingFailureException;

    void deleteTransportRequest(String trackNum);





    
}
