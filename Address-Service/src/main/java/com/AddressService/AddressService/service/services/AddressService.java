package com.AddressService.AddressService.service.services;

import com.AddressService.AddressService.model.Addresses.CompanyAddress;
import com.AddressService.AddressService.model.Addresses.TransporterAddress;

public interface AddressService {

    void saveBusinessAddress(CompanyAddress companyAddress) throws Exception;

    void saveTransporterAddress(TransporterAddress transporterAddress);

    CompanyAddress getBusinessAddress(String authID) throws Exception;
    TransporterAddress getTransporterAddress(String authID);
}
