package com.GregorianaUserService.User.Service.Service.Services;

import com.GregorianaUserService.User.Service.Model.Clients.Address.BusinessAddress;
import com.GregorianaUserService.User.Service.Model.Clients.BusinessClient;

public interface BusinessClientService {


    void updatePhotoUrl(String photoUrl,String auth);

   void updatePhone(Long phone,String authID);

    void updateAddress(BusinessAddress address, String authID) throws Exception;

    void save_Business_Client(BusinessClient businessClient) throws Exception;

    BusinessClient getBusinessClient(String email, String authID) throws Exception;


}
