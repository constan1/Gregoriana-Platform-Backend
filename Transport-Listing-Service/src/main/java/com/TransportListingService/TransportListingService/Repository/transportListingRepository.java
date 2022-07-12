package com.TransportListingService.TransportListingService.Repository;

import com.TransportListingService.TransportListingService.model.TransportListing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface transportListingRepository extends JpaRepository<TransportListing, Long> {

    @Query("select distinct t from Transport_Listing  t left join fetch t.vehicle where t.authID =:authID")
    TransportListing getTransportListing(@Param("authID") String authID);


}
