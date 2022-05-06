package com.GregorianaUserService.User.Service.Service.Implementation;

import com.GregorianaUserService.User.Service.AES.AES;
import com.GregorianaUserService.User.Service.Model.Clients.Address.CustomerAddress;
import com.GregorianaUserService.User.Service.Model.Clients.RetailClient;
import com.GregorianaUserService.User.Service.Repository.RetailClientRepository;
import com.GregorianaUserService.User.Service.Service.Services.RetailClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Key;


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

        Key key = AES.generateKey();

        String encryptedStreet = AES.encrypt(address.getStreet_address(),key);
        String enryptPostalCode= AES.encrypt(address.getPostal_code(),key);

        retailClientRepository.updateAddress(address.getCountry(),encryptedStreet, address.getCity(),
                address.getProvince(), enryptPostalCode,authID);
    }

    @Override
    public void save_Retail_Client(RetailClient retailClient) throws Exception {

        Key key = AES.generateKey();

        String encryptedEmail = AES.encrypt(retailClient.getUser().getEmail(),key);
        retailClient.getUser().setEmail(encryptedEmail);

        retailClientRepository.save(retailClient);
    }

    @Override
    public RetailClient getRetailClient(String email, String authID) throws Exception {

        Key key = AES.generateKey();


        String encryptedEmailToDatabase = AES.encrypt(email,key);


        RetailClient retailClient = retailClientRepository.selectRetailClient(encryptedEmailToDatabase, authID);

        if(retailClient.getAddress().getStreet_address()!= null){
            retailClient.getAddress().setStreet_address(AES.decrypt(retailClient.getAddress().getStreet_address(), key));
        }
        if(retailClient.getAddress().getPostal_code() !=null){
            retailClient.getAddress().setPostal_code(AES.decrypt(retailClient.getAddress().getPostal_code() ,key));
        }
        retailClient.getUser().setEmail(AES.decrypt(retailClient.getUser().getEmail(),key));

        return retailClient;
    }
}