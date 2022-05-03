package com.GregorianaUserService.User.Service.Service;

import com.GregorianaUserService.User.Service.Model.Address;
import com.GregorianaUserService.User.Service.Model.Clients.TransporterClient;
import com.GregorianaUserService.User.Service.Model.User;
import com.GregorianaUserService.User.Service.Model.Vehicle;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface TransporterService {

    TransporterClient getTransporter(String authID);

    void Save_TransporterClient(TransporterClient transporterClient);

    void save_or_update_Address(TransporterClient transporterClient);

    void updatePhotoUrl( String photoUrl,String authId);


    void updateVerified( Boolean verified, String authId);

    void updatePhone(Long phone,String authID);

    void save_or_update_vehicle(TransporterClient transporterClient);


}