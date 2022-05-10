package com.GregorianaUserService.User.Service.Service.Implementation;

import com.GregorianaUserService.User.Service.AES.PBK2;
import com.GregorianaUserService.User.Service.Model.Clients.Address.CustomerAddress;
import com.GregorianaUserService.User.Service.Model.Clients.RetailClient;
import com.GregorianaUserService.User.Service.Repository.RetailClientRepository;
import com.GregorianaUserService.User.Service.Service.Services.RetailClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class RetailClientImpl implements RetailClientService {


    private final RetailClientRepository retailClientRepository;


    @Override
    public void updatePhotoUrl(String photoUrl, String authId) {

        retailClientRepository.updatePhotoUrl(photoUrl, authId);
    }

    @Override
    public void updatePhone(Long phone,  String authID) {

        retailClientRepository.updatePhone(phone, authID);
    }

    @Override
    public void updateAddress(CustomerAddress address, String authID) throws Exception  {


        String encryptedStreet = PBK2.encrypt(address.getStreet_address());

        String enryptPostalCode = PBK2.encrypt(address.getPostal_code());

        retailClientRepository.updateAddress(address.getCountry(),encryptedStreet, address.getCity(),
                address.getProvince(), enryptPostalCode,authID);
    }

    @Override
    public void save_Retail_Client(RetailClient retailClient) throws Exception {

        retailClientRepository.save(retailClient);
    }

    @Override
    public RetailClient getRetailClient( String authID) throws Exception {




        RetailClient retailClient = retailClientRepository.selectRetailClient(authID);

        if(retailClient != null) {

            if (retailClient.getAddress().getStreet_address() != null) {
                retailClient.getAddress().setStreet_address(PBK2.decrypt(retailClient.getAddress().getStreet_address()));
            }
            if (retailClient.getAddress().getPostal_code() != null) {
                retailClient.getAddress().setPostal_code(PBK2.decrypt(retailClient.getAddress().getPostal_code()));
            }
        }
        else {
            return null;
        }
        return retailClient;
    }
}