
package com.GregorianaUserService.User.Service.Service.Implementation;

import com.GregorianaUserService.User.Service.AES.PBK2;
import com.GregorianaUserService.User.Service.Model.Clients.Address.TransporterAddress;
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
    public  TransporterClient  getTransporter(String authID) throws Exception {



       TransporterClient transporterClient =  transporterRepository.getTransporter(authID);

       if(transporterClient.getDrivers_license().getDrivers_photo_url() !=null){
           transporterClient.getDrivers_license().setDrivers_photo_url(PBK2.decrypt(transporterClient.getDrivers_license().getDrivers_photo_url()));
       }

        if(transporterClient.getAddress().getStreet_address() != null){
            transporterClient.getAddress().setStreet_address(PBK2.decrypt(transporterClient.getAddress().getStreet_address()));
        }
        if(transporterClient.getAddress().getPostal_code() !=null){
            transporterClient.getAddress().setPostal_code(PBK2.decrypt(transporterClient.getAddress().getPostal_code()));
        }

       transporterClient.getUser().setEmail(PBK2.decrypt(transporterClient.getUser().getEmail()));

        return transporterClient;
    }



    @Override
    public void Save_TransporterClient(TransporterClient transporterClient) throws Exception {

        String encryptedEmail = PBK2.encrypt(transporterClient.getUser().getEmail());

        transporterClient.getUser().setEmail(encryptedEmail);
        transporterRepository.save(transporterClient);
    }

    @Override
    public void updatePhotoUrl(String photoUrl, String authId) {
        transporterRepository.updatePhotoUrl(photoUrl, authId);
    }

    @Override
    public void updateVerified(Boolean verified,  String authId) {
        transporterRepository.updateVerified(verified, authId);
    }

    @Override
    public void updatePhone(Long phone,String authID) {

        transporterRepository.updatePhone(phone, authID);
    }

    @Override
    public void updateAddress(TransporterAddress address, String authID) throws Exception {



        String encryptedStreet = PBK2.encrypt(address.getStreet_address());
        String enryptPostalCode = PBK2.encrypt(address.getPostal_code());


        transporterRepository.updateAddress(address.getCountry(),encryptedStreet, address.getCity(),
                address.getProvince(),enryptPostalCode,authID);
    }

    @Override
    public void updateLicensePhoto(String url, String authID) throws Exception {


        String encryptedDriversLicense = PBK2.encrypt(url);

        transporterRepository.updateLicensePhoto(encryptedDriversLicense, authID);
    }



}
