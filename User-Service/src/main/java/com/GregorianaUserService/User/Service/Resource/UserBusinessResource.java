package com.GregorianaUserService.User.Service.Resource;


import com.GregorianaUserService.User.Service.Model.Clients.BusinessClient;
import com.GregorianaUserService.User.Service.Model.DTO.AddressDTO.BusinessAddressDTO;
import com.GregorianaUserService.User.Service.Model.DTO.ClientDTO;
import com.GregorianaUserService.User.Service.Model.DTO.PhoneDTO;
import com.GregorianaUserService.User.Service.Model.DTO.PhotoDTO;
import com.GregorianaUserService.User.Service.Service.Services.BusinessClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user/business")
@RequiredArgsConstructor
public class UserBusinessResource {



    private final BusinessClientService businessClientService;


    @PostMapping("/client")
    @ResponseStatus(HttpStatus.CREATED)
    public void createBusinessClient(@RequestBody BusinessClient businessClient) throws Exception {

        businessClientService.save_Business_Client(businessClient);
    }

    @RequestMapping(value = "/client/{authID}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public BusinessClient getBusinessClient(@PathVariable(name ="authID") String authID) throws Exception {
        return businessClientService.getBusinessClient(authID);
    }

    @PutMapping("/client/updateAddress")
    @ResponseStatus(HttpStatus.OK)
    public void updateAddress(@RequestBody BusinessAddressDTO addressDTO) throws Exception {
        businessClientService.updateAddress(addressDTO.getAddress(),addressDTO.getAuthID());
    }

    @PutMapping("/client/updatePhotoUrl")
    @ResponseStatus(HttpStatus.OK)
    public void updatePhoto(@RequestBody PhotoDTO photoDTO){
        businessClientService.updatePhotoUrl(photoDTO.getPhotoUrl(), photoDTO.getAuthID());
    }


    @PutMapping("/client/updatePhone")
    @ResponseStatus(HttpStatus.OK)
    public void updatePhone(@RequestBody PhoneDTO phoneDTO){
        businessClientService.updatePhone(phoneDTO.getPhone(),phoneDTO.getAuthID());
    }


}
