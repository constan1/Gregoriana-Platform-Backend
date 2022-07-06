package com.AddressService.AddressService.service.Implementation;


import com.AddressService.AddressService.AES.PBK2;
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
    public void saveBusinessAddress(CompanyAddress companyAddress) throws Exception {

        companyAddress.setCompany_address_street(PBK2.encrypt(companyAddress.getCompany_address_street()));

        companyAddress.setCompany_address_postalCode(PBK2.encrypt(companyAddress.getCompany_address_postalCode()));
        companyAddressRepository.save(companyAddress);
    }

    @Override
    public void saveTransporterAddress(TransporterAddress transporterAddress) {
        transportAddressRepository.save(transporterAddress);
    }

    @Override
    public CompanyAddress getBusinessAddress(String authID) throws Exception {

        CompanyAddress companyAddress = companyAddressRepository.getCompanyAddressByAuthID(authID);

        if (companyAddress.getCompany_address_street() != null && companyAddress.getCompany_address_postalCode() != null) {
            companyAddress.setCompany_address_street(PBK2.decrypt(companyAddress.getCompany_address_street()));
            companyAddress.setCompany_address_postalCode(PBK2.decrypt(companyAddress.getCompany_address_postalCode()));

            return companyAddress;
        } else if (companyAddress.getCompany_address_street() != null) {
            companyAddress.setCompany_address_street(PBK2.decrypt(companyAddress.getCompany_address_street()));

            return companyAddress;
        } else if (companyAddress.getCompany_address_postalCode() != null) {
            companyAddress.setCompany_address_postalCode(PBK2.decrypt(companyAddress.getCompany_address_postalCode()));
            return companyAddress;
        } else {
            return companyAddress;
        }
    }


    @Override
    public TransporterAddress getTransporterAddress(String authID) {

        return transportAddressRepository.getTransporterAddressByAuthID(authID);
    }
}
