package com.AddressService.AddressService.repository;

import com.AddressService.AddressService.model.Addresses.CompanyAddress;
import com.AddressService.AddressService.model.Addresses.TransporterAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CompanyAddressRepository extends JpaRepository<CompanyAddress, Long> {

    @Query("select c from Business_Address c where c.authID =:authID")
    CompanyAddress getCompanyAddressByAuthID(@Param("authID") String authID);

}
