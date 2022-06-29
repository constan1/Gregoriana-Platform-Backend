package com.GregorianaUserService.User.Service.Service.Implementation;

import com.GregorianaUserService.User.Service.AES.PBK2;
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
    public void updatePhone(Long phone, String authID) {

        retailClientRepository.updatePhone(phone, authID);
    }

    @Override
    public void save_Retail_Client(RetailClient retailClient) throws Exception {
        retailClientRepository.save(retailClient);
    }


    @Override
    public RetailClient getRetailClient(String authID) throws Exception {


        return retailClientRepository.selectRetailClient(authID);
    }
}