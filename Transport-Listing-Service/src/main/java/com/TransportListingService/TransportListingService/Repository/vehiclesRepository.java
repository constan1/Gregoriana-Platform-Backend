package com.TransportListingService.TransportListingService.Repository;

import com.TransportListingService.TransportListingService.model.vehicles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface vehiclesRepository extends JpaRepository<vehicles,Long> {

    @Query("select  distinct v from vehicles v where v.authID =:authID AND v.email =:email")
    vehicles getVehicles(@Param("authID")String authID, @Param("email") String email);

}
