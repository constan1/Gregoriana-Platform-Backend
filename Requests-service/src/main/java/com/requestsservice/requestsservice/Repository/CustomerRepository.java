package com.requestsservice.requestsservice.Repository;

import com.requestsservice.requestsservice.Model.TransportRequests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<TransportRequests,Long> {


    @Query("select distinct t from Transport_Requests t left join fetch  t.stops s left join fetch s.dropOffs left join fetch  t.addOn where t.authID =:authID")
    List<TransportRequests> getRequestForClient(@Param("authID")String authID);

    @Query("select distinct t from Transport_Requests t left join fetch t.stops s left join  fetch s.dropOffs left join fetch t.addOn where t.trackingNumber =:trackingNum ")
    TransportRequests getTransportRequestByTrackingNumber(@Param("trackingNum") String trackNum);

}
