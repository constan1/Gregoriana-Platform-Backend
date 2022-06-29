package com.GregorianaUserService.User.Service.Service.Services;

import com.GregorianaUserService.User.Service.Model.Clients.BusinessClient;

public interface BusinessClientService {


    void updatePhotoUrl(String photoUrl,String auth);

   void updatePhone(Long phone,String authID);

    void save_Business_Client(BusinessClient businessClient) throws Exception;

    BusinessClient getBusinessClient( String authID) throws Exception;


}
