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


    @CacheEvict(value="Business_profile", allEntries = true,beforeInvocation = true)
    @PostMapping("/client")
    @ResponseStatus(HttpStatus.CREATED)
    public void createBusinessClient(@RequestBody BusinessClient businessClient) throws Exception {

        businessClientService.save_Business_Client(businessClient);
    }

    @Cacheable("Business_profile")
    @GetMapping("/client")
    @ResponseStatus(HttpStatus.OK)
    public BusinessClient getBusinessClient(@RequestBody ClientDTO clientDTO) throws Exception {
        return businessClientService.getBusinessClient(clientDTO.getEmail(),clientDTO.getAuthID());
    }

    @CacheEvict(value="Business_profile", allEntries = true,beforeInvocation = true)
    @PutMapping("/client/updateAddress")
    @ResponseStatus(HttpStatus.OK)
    public void updateAddress(@RequestBody BusinessAddressDTO addressDTO) throws Exception {
        businessClientService.updateAddress(addressDTO.getAddress(),addressDTO.getAuthID());
    }

    @CacheEvict(value="Business_profile", allEntries = true,beforeInvocation = true)
    @PutMapping("/client/updatePhotoUrl")
    @ResponseStatus(HttpStatus.OK)
    public void updatePhoto(@RequestBody PhotoDTO photoDTO){
        businessClientService.updatePhotoUrl(photoDTO.getPhotoUrl(), photoDTO.getAuthID());
    }


    @CacheEvict(value="Business_profile", allEntries = true,beforeInvocation = true)
    @PutMapping("/client/updatePhone")
    @ResponseStatus(HttpStatus.OK)
    public void updatePhone(@RequestBody PhoneDTO phoneDTO){
        businessClientService.updatePhone(phoneDTO.getPhone(),phoneDTO.getAuthID());
    }


}
