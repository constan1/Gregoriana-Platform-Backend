package com.GregorianaUserService.User.Service.Service.Implementation;

import com.GregorianaUserService.User.Service.Model.Clients.BusinessClient;
import com.GregorianaUserService.User.Service.Repository.BusinessClientRepository;
import com.GregorianaUserService.User.Service.Service.Services.BusinessClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


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
    public void updateAddress(String country, String street_address, String city, String province, String postal_Code, String authID) {

        businessClientRepository.updateAddress(country,street_address,city,province,postal_Code,authID);
    }

    @Override
    public void save_Business_Client(BusinessClient businessClient) {

        businessClientRepository.save(businessClient);
    }

    @Override
    public BusinessClient getBusinessClient(String authID) {
        return businessClientRepository.selectBusinessClient(authID);
    }
}
