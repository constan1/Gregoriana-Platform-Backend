package com.RequestService.Request.Service.Repository;


import com.RequestService.Request.Service.Model.Consumers.privateRequest.TransportRequests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<TransportRequests,Long> {

    @Query("select distinct t from Transport_Requests t left join fetch  t.stops s left join fetch s.dropOffs left join fetch  t.addOn where t.authID =:authID")
    List<TransportRequests> getRequestForClient(@Param("authID")String authID);

    @Query("select distinct t from Transport_Requests t left join fetch t.stops s left join  fetch s.dropOffs left join fetch t.addOn where t.trackingNumber =:trackingNum ")
     TransportRequests getTransportRequestByTrackingNumber(@Param("trackingNum") String trackNum);



    @Query("select distinct t from Transport_Requests t  left join fetch t.stops s left join fetch s.dropOffs left join fetch t.addOn where t.status =:pending")
    List<TransportRequests> getRequestForMarket(@Param("pending")String pending);



    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Transport_Requests t set t.status =:status where t.trackingNumber =:trackingNum")
    void updateRequestStatus(@Param("trackingNum") String trackingNumber,@Param("status") String status);


}
