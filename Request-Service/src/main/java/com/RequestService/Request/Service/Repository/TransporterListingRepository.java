package com.RequestService.Request.Service.Repository;

import com.RequestService.Request.Service.Model.Transporters.TransportListing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransporterListingRepository extends JpaRepository<TransportListing,String> {

    @Query("select i from Transporters_Inquiries  i where i.email =: email")
    TransportListing getTransportersListing(@Param("email") String email);


}
