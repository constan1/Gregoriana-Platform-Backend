package com.AddressService.AddressService.repository;

import com.AddressService.AddressService.model.Addresses.TransporterAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransportAddressRepository extends JpaRepository<TransporterAddress, Long> {


    @Query("select t from Transporter_Address t where t.authID =:authID")
    TransporterAddress getTransporterAddressByAuthID(@Param("authID") String authID);
}
