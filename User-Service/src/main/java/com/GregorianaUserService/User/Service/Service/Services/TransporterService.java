package com.GregorianaUserService.User.Service.Service.Services;

import com.GregorianaUserService.User.Service.Model.Clients.Address.TransporterAddress;
import com.GregorianaUserService.User.Service.Model.Clients.TransporterClient;
import com.GregorianaUserService.User.Service.Model.Vehicles.Vehicle;


public interface TransporterService {

    TransporterClient getTransporter(String authID) throws Exception;

    void Save_TransporterClient(TransporterClient transporterClient) throws Exception;

    void updatePhotoUrl(String photoUrl, String authId);



    void updateVerified(Boolean verified,String authId);

    void updatePhone(Long phone,String authID);

    void updateAddress(TransporterAddress address,String authID) throws Exception;


    void updateVehicle(Vehicle vehicle, String authID) throws Exception;


}