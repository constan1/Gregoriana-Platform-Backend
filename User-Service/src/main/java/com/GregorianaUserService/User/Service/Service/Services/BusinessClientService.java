package com.GregorianaUserService.User.Service.Service.Services;

import com.GregorianaUserService.User.Service.Model.Clients.BusinessClient;

public interface BusinessClientService {


    void updatePhotoUrl( String photoUrl,String authId);

    void updatePhone(Long phone,String authID);

    void updateAddress(String country, String street_address,  String city,
                       String province, String postal_Code, String authID);

    void save_Business_Client(BusinessClient businessClient);

    BusinessClient getBusinessClient(String authID);


}
