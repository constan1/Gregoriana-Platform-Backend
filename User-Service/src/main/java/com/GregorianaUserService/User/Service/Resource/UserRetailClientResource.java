package com.GregorianaUserService.User.Service.Resource;


import com.GregorianaUserService.User.Service.Model.Clients.RetailClient;
import com.GregorianaUserService.User.Service.Model.DTO.AddressDTO;
import com.GregorianaUserService.User.Service.Model.DTO.ClientDTO;
import com.GregorianaUserService.User.Service.Model.DTO.PhoneDTO;
import com.GregorianaUserService.User.Service.Model.DTO.PhotoDTO;
import com.GregorianaUserService.User.Service.Service.Services.RetailClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user/retail")
@RequiredArgsConstructor
public class UserRetailClientResource {


    private final RetailClientService retailClientService;


    @PostMapping("/client")
    @ResponseStatus(HttpStatus.CREATED)
    public void createRetailClient(@RequestBody RetailClient retailClient){

        retailClientService.save_Retail_Client(retailClient);
    }


    @GetMapping("/client")
    @ResponseStatus(HttpStatus.OK)
    public RetailClient getRetailClient(@RequestBody ClientDTO clientDTO){
        return retailClientService.getRetailClient(clientDTO.getAuthID());
    }


    @PutMapping("/client/updateAddress")
    @ResponseStatus(HttpStatus.OK)
    public void updateAddress(@RequestBody AddressDTO retailClientAddress){
        retailClientService.updateAddress(retailClientAddress.getAddress().getCountry(),
                retailClientAddress.getAddress().getStreet_address(),
                retailClientAddress.getAddress().getCity(),
                retailClientAddress.getAddress().getProvince(),
                retailClientAddress.getAddress().getPostal_code(),
                retailClientAddress.getAuthID());
    }

    @PutMapping("/client/updatePhone")
    @ResponseStatus(HttpStatus.OK)
    public void updatePhone(@RequestBody PhoneDTO phoneDTO){

        retailClientService.updatePhone(phoneDTO.getPhone(),phoneDTO.getAuthID());
    }

    @PutMapping("/client/updatePhotoUrl")
    @ResponseStatus(HttpStatus.OK)
    public void updatePhotoUrl(@RequestBody PhotoDTO photoDTO){
        retailClientService.updatePhotoUrl(photoDTO.getPhotoUrl(),photoDTO.getAuthID());
    }




}
