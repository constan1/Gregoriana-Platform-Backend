package com.GregorianaUserService.User.Service.Service.Services;

import com.GregorianaUserService.User.Service.Model.Clients.RetailClient;

public interface RetailClientService {

    void updatePhotoUrl(String photoUrl,String authId);

    void updatePhone(Long phone,String authID);

    void save_Retail_Client(RetailClient retailClient) throws Exception;

    RetailClient getRetailClient( String authID) throws Exception;

}
