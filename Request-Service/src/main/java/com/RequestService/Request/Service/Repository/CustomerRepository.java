package com.RequestService.Request.Service.Repository;


import com.RequestService.Request.Service.Model.Consumers.TransportRequests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<TransportRequests,Long> {

    @Query("select t from Transport_Requests t where t.authID =:authID")
    List<TransportRequests> getRequestForClient(@Param("authID")String authID);

}
