package com.GregorianaUserService.User.Service.Service.Implementation;

import com.GregorianaUserService.User.Service.AES.AES;
import com.GregorianaUserService.User.Service.Model.Address;
import com.GregorianaUserService.User.Service.Model.Clients.BusinessClient;
import com.GregorianaUserService.User.Service.Repository.BusinessClientRepository;
import com.GregorianaUserService.User.Service.Service.Services.BusinessClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Key;


@RequiredArgsConstructor
@Service
public class BusinessClientImpl implements BusinessClientService {


    private final BusinessClientRepository businessClientRepository;

    @Override
    public void updatePhotoUrl(String photoUrl, String authId) {


        businessClientRepository.updatePhotoUrl(photoUrl,authId);
    }

    @Override
    public void updatePhone(Long phone, String authID) {

        businessClientRepository.updatePhone(phone,authID);
    }

    @Override
    public void updateAddress(Address address, String authID) throws Exception{


        Key key = AES.generateKey();

        String encryptedStreet = AES.encrypt(address.getStreet_address(),key);
        String enryptPostalCode= AES.encrypt(address.getPostal_code(),key);

        businessClientRepository.updateAddress(address.getCountry(),encryptedStreet,address.getCity(),
                address.getProvince(),enryptPostalCode,authID);
    }

    @Override
    public void save_Business_Client(BusinessClient businessClient) throws Exception {
        Key key = AES.generateKey();


        String encryptedEmail = AES.encrypt(businessClient.getUser().getEmail(),key);

        businessClient.getUser().setEmail(encryptedEmail);

        businessClientRepository.save(businessClient);
    }

    @Override
    public BusinessClient getBusinessClient(String authID) throws Exception {

        Key key = AES.generateKey();


        BusinessClient businessClient =  businessClientRepository.selectBusinessClient(authID);

        if(businessClient.getAddress().getStreet_address()!=null){
            businessClient.getAddress().setStreet_address(AES.decrypt(businessClient.getAddress().getStreet_address(),key));
        }
        if(businessClient.getAddress().getPostal_code() !=null){
            businessClient.getAddress().setPostal_code(AES.decrypt(businessClient.getAddress().getPostal_code(),key));
        }
        businessClient.getUser().setEmail(AES.decrypt(businessClient.getUser().getEmail(),key));

        return businessClient;

    }
}
