package com.GregorianaUserService.User.Service.Service.Services;

import com.GregorianaUserService.User.Service.Model.Clients.TransporterClient;



public interface TransporterService {

    TransporterClient getTransporter(String authID) throws Exception;

    void Save_TransporterClient(TransporterClient transporterClient) throws Exception;

    void updatePhotoUrl(String photoUrl, String authId);



    void updateVerified(Boolean verified,String authId);

    void updatePhone(Long phone,String authID);


}