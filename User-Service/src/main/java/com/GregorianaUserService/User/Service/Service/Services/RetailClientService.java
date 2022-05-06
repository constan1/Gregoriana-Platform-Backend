package com.GregorianaUserService.User.Service.Service.Services;

import com.GregorianaUserService.User.Service.Model.Clients.Address.CustomerAddress;
import com.GregorianaUserService.User.Service.Model.Clients.RetailClient;

public interface RetailClientService {

    void updatePhotoUrl(String photoUrl,String authId);

    void updatePhone(Long phone,String authID);

    void updateAddress(CustomerAddress address,String authID) throws Exception;

    void save_Retail_Client(RetailClient retailClient) throws Exception;

    RetailClient getRetailClient(String email, String authID) throws Exception;

}
