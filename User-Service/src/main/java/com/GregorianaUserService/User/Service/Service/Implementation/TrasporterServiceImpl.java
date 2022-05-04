package com.GregorianaUserService.User.Service.Service.Implementation;

import com.GregorianaUserService.User.Service.Model.Clients.TransporterClient;
import com.GregorianaUserService.User.Service.Repository.TransporterRepository;
import com.GregorianaUserService.User.Service.Service.Services.TransporterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


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
    public void updateAddress(String country, String street_address,
                              String city, String province,
                              String postal_Code, String AuthID)
    {
        transporterRepository.updateAddress(country,street_address,city,province,postal_Code, AuthID);
    }

    @Override
    public void updateVehicle(String type, String make, Integer year,
                              Integer condition, String description,
                              Integer capacity, String load,
                              String license_plate, String ownership,
                              String first_url, String second_url,
                              String third_url, String authID)
    {
        transporterRepository.updateVehicle(type,make,year,condition,description,capacity,load,license_plate,ownership,
                first_url,second_url,third_url,authID);
    }


}
