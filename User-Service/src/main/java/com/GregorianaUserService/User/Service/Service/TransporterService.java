package com.GregorianaUserService.User.Service.Service;

import com.GregorianaUserService.User.Service.Model.Clients.TransporterClient;
import com.GregorianaUserService.User.Service.Model.Vehicle;

import java.util.Collection;
import java.util.List;

public interface TransporterService {

    TransporterClient  getTransporter(String authID);


    void updateVehicles(List<Vehicle> Vehicles, String authID);

    void Save_TransporterClient(TransporterClient transporterClient);
}
