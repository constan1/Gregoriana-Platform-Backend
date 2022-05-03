package com.GregorianaUserService.User.Service.Service;

import com.GregorianaUserService.User.Service.Model.Address;
import com.GregorianaUserService.User.Service.Model.Clients.TransporterClient;
import com.GregorianaUserService.User.Service.Model.User;
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
    public void Save_TransporterClient(TransporterClient transporterClient) {

        transporterRepository.save(transporterClient);
    }

    @Override
    public void save_or_update_Address(TransporterClient transporterClient) {
        transporterRepository.save(transporterClient);
    }

    @Override
    public void updatePhotoUrl(String photoUrl, String authId) {
        transporterRepository.updatePhotoUrl(photoUrl,authId);
    }

    @Override
    public void updateVerified(Boolean verified, String authId) {
        transporterRepository.updateVerified(verified,authId);
    }

    @Override
    public void updatePhone(Long phone, String authID) {

        transporterRepository.updatePhone(phone,authID);
    }

    @Override
    public void save_or_update_vehicle(TransporterClient transporterClient) {
        transporterRepository.save(transporterClient);
    }


}
