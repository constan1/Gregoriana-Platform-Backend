
package com.GregorianaUserService.User.Service.Service.Implementation;

import com.GregorianaUserService.User.Service.AES.PBK2;
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

        return transporterRepository.getTransporter(authID);
    }



    @Override
    public void Save_TransporterClient(TransporterClient transporterClient) throws Exception {

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


}
