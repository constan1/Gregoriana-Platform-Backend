package com.GregorianaUserService.User.Service.Service.Implementation;

import com.GregorianaUserService.User.Service.AES.PBK2;
import com.GregorianaUserService.User.Service.Model.Clients.Address.BusinessAddress;
import com.GregorianaUserService.User.Service.Model.Clients.BusinessClient;
import com.GregorianaUserService.User.Service.Repository.BusinessClientRepository;
import com.GregorianaUserService.User.Service.Service.Services.BusinessClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class BusinessClientImpl implements BusinessClientService {


    private final BusinessClientRepository businessClientRepository;

    @Override
    public void updatePhotoUrl(String photoUrl, String authId) {


        businessClientRepository.updatePhotoUrl(photoUrl,authId);
    }

    @Override
    public void updatePhone(Long phone, String authID) {

        businessClientRepository.updatePhone( phone,authID);
    }

    @Override
    public void updateAddress (BusinessAddress address,String authID) throws Exception{

        String encryptedStreet = PBK2.encrypt(address.getStreet_address());
        String enryptPostalCode = PBK2.encrypt(address.getPostal_code());


        businessClientRepository.updateAddress(address.getCountry(),encryptedStreet,address.getCity(),
                address.getProvince(),enryptPostalCode,authID);
    }

    @Override
    public void save_Business_Client(BusinessClient businessClient) throws Exception {


        String encryptedEmail = PBK2.encrypt(businessClient.getUser().getEmail());

        businessClient.getUser().setEmail(encryptedEmail);

        businessClientRepository.save(businessClient);
    }

    @Override
    public BusinessClient getBusinessClient(String authID) throws Exception {




        BusinessClient businessClient =  businessClientRepository.selectBusinessClient(authID);

        if(businessClient.getAddress().getStreet_address()!=null){
            businessClient.getAddress().setStreet_address(PBK2.decrypt(businessClient.getAddress().getStreet_address()));
        }
        if(businessClient.getAddress().getPostal_code() !=null){
            businessClient.getAddress().setPostal_code(PBK2.decrypt(businessClient.getAddress().getPostal_code()));
        }


        businessClient.getUser().setEmail(PBK2.decrypt(businessClient.getUser().getEmail()));

        return businessClient;

    }
}
