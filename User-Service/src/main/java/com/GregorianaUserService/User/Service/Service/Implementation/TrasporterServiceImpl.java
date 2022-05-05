
package com.GregorianaUserService.User.Service.Service.Implementation;

import com.GregorianaUserService.User.Service.AES.AES;
import com.GregorianaUserService.User.Service.Model.Address;
import com.GregorianaUserService.User.Service.Model.Clients.TransporterClient;
import com.GregorianaUserService.User.Service.Model.Vehicle;
import com.GregorianaUserService.User.Service.Repository.TransporterRepository;
import com.GregorianaUserService.User.Service.Service.Services.TransporterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Key;


@RequiredArgsConstructor
@Service
public class TrasporterServiceImpl implements TransporterService {

    private final TransporterRepository transporterRepository;


    @Override
    public  TransporterClient  getTransporter(String authID) throws Exception {


        Key key = AES.generateKey();

       TransporterClient transporterClient =  transporterRepository.getTransporter(authID);


        if(transporterClient.getVehicle().getOwnership_paper() != null){
            transporterClient.getVehicle().setOwnership_paper(AES.decrypt(transporterClient.getVehicle().getOwnership_paper(),key));
        }
        if(transporterClient.getAddress().getStreet_address() != null){
            transporterClient.getAddress().setStreet_address(AES.decrypt(transporterClient.getAddress().getStreet_address(),key));
        }
        if(transporterClient.getAddress().getPostal_code() !=null){
            transporterClient.getAddress().setPostal_code(AES.decrypt(transporterClient.getAddress().getPostal_code(),key));
        }

       transporterClient.getUser().setEmail(AES.decrypt(transporterClient.getUser().getEmail(),key));

        return transporterClient;
    }



    @Override
    public void Save_TransporterClient(TransporterClient transporterClient) throws Exception {
        Key key = AES.generateKey();


        String encryptedEmail = AES.encrypt(transporterClient.getUser().getEmail(),key);
        transporterClient.getUser().setEmail(encryptedEmail);
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
    public void updateAddress(Address address, String authID) throws Exception {


        Key key = AES.generateKey();

        String encryptedStreet = AES.encrypt(address.getStreet_address(),key);
        String enryptPostalCode= AES.encrypt(address.getPostal_code(),key);


        transporterRepository.updateAddress(address.getCountry(),encryptedStreet, address.getCity(),
                address.getProvince(),enryptPostalCode,authID);
    }

    @Override
    public void updateVehicle(Vehicle vehicle, String authID) throws Exception {

        Key key = AES.generateKey();

        String encryptedDriversLicense = AES.encrypt(vehicle.getOwnership_paper(),key);

        transporterRepository.updateVehicle(vehicle.getType(),vehicle.getMake(),vehicle.getYear(),vehicle.getCondition(),
                vehicle.getDescription(),vehicle.getCapacity(),vehicle.getLoad(),vehicle.getLicense_plate(),
                encryptedDriversLicense,vehicle.getFirst_photo_url(),vehicle.getSecond_photo_url(),
                vehicle.getThird_photo_url(),authID);



    }


}
