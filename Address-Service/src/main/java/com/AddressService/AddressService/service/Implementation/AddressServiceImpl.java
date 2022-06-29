package com.AddressService.AddressService.service.Implementation;


import com.AddressService.AddressService.model.Addresses.CompanyAddress;
import com.AddressService.AddressService.model.Addresses.TransporterAddress;
import com.AddressService.AddressService.repository.CompanyAddressRepository;
import com.AddressService.AddressService.repository.TransportAddressRepository;
import com.AddressService.AddressService.service.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {


    private final CompanyAddressRepository companyAddressRepository;
    private final TransportAddressRepository transportAddressRepository;


    @Override
    public void saveBusinessAddress(CompanyAddress companyAddress) {
        companyAddressRepository.save(companyAddress);
    }

    @Override
    public void saveTransporterAddress(TransporterAddress transporterAddress) {
        transportAddressRepository.save(transporterAddress);
    }

    @Override
    public CompanyAddress getBusinessAddress(String authID) {

        return companyAddressRepository.getCompanyAddressByAuthID(authID);

    }

    @Override
    public TransporterAddress getTransporterAddress(String authID) {

        return transportAddressRepository.getTransporterAddressByAuthID(authID);
    }
}
