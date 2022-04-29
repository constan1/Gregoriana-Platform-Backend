package com.GregorianaUserService.User.Service.Service;

import com.GregorianaUserService.User.Service.Model.Clients.TransporterClient;
import com.GregorianaUserService.User.Service.Model.Vehicle;
import com.GregorianaUserService.User.Service.Repository.TransporterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.List;


@RequiredArgsConstructor
@Service
public class TrasporterServiceImpl implements TransporterService {

    private final TransporterRepository transporterRepository;


    @Override
    public  TransporterClient  getTransporter(String authID) {
        return transporterRepository.getTransporter(authID);
    }

    @Override
    public void updateVehicles(List<Vehicle> Vehicles, String authID) {

        transporterRepository.updateVehicles(Vehicles,authID);
    }

    @Override
    public void Save_TransporterClient(TransporterClient transporterClient) {

        Date date = new Date(System.currentTimeMillis());
        transporterClient.getUser().setDate_joined(date);

        transporterRepository.save(transporterClient);
    }
}
