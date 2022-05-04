package com.GregorianaUserService.User.Service.Service.Implementation;

import com.GregorianaUserService.User.Service.Model.Address;
import com.GregorianaUserService.User.Service.Model.Clients.TransporterClient;
import com.GregorianaUserService.User.Service.Model.Vehicle;
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
    public void updateAddress(Address address, String authID) {
        transporterRepository.updateAddress(address.getCountry(),address.getStreet_address(), address.getCity(),
                address.getProvince(),address.getPostal_code(),authID);
    }

    @Override
    public void updateVehicle(Vehicle vehicle, String authID) {

        transporterRepository.updateVehicle(vehicle.getType(),vehicle.getMake(),vehicle.getYear(),vehicle.getCondition(),
                vehicle.getDescription(),vehicle.getCapacity(),vehicle.getLoad(),vehicle.getLicense_plate(),
                vehicle.getOwnership_paper(),vehicle.getFirst_photo_url(),vehicle.getSecond_photo_url(),
                vehicle.getThird_photo_url(),authID);



    }


}
