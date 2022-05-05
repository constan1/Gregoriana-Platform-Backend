package com.GregorianaUserService.User.Service.Service.Services;

import com.GregorianaUserService.User.Service.Model.Address;
import com.GregorianaUserService.User.Service.Model.Clients.BusinessClient;

public interface BusinessClientService {


    void updatePhotoUrl( String photoUrl,String authId);

    void updatePhone(Long phone,String authID);

    void updateAddress(Address address, String authID) throws Exception;

    void save_Business_Client(BusinessClient businessClient) throws Exception;

    BusinessClient getBusinessClient(String authID) throws Exception;


}
