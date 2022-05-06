package com.GregorianaUserService.User.Service.Resource;


import com.GregorianaUserService.User.Service.Model.Clients.RetailClient;
import com.GregorianaUserService.User.Service.Model.DTO.AddressDTO.CustomerAddressDTO;
import com.GregorianaUserService.User.Service.Model.DTO.ClientDTO;
import com.GregorianaUserService.User.Service.Model.DTO.PhoneDTO;
import com.GregorianaUserService.User.Service.Model.DTO.PhotoDTO;
import com.GregorianaUserService.User.Service.Service.Services.RetailClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user/retail")
@RequiredArgsConstructor
public class UserRetailClientResource {


    private final RetailClientService retailClientService;

    @CacheEvict(value="Retail_profile", allEntries = true,beforeInvocation = true)
    @PostMapping("/client")
    @ResponseStatus(HttpStatus.CREATED)
    public void createRetailClient(@RequestBody RetailClient retailClient) throws Exception {

        retailClientService.save_Retail_Client(retailClient);
    }

    @Cacheable("Retail_profile")
    @GetMapping("/client")
    @ResponseStatus(HttpStatus.OK)
    public RetailClient getRetailClient(@RequestBody ClientDTO clientDTO) throws Exception {
        return retailClientService.getRetailClient(clientDTO.getEmail(),clientDTO.getAuthID());
    }

    @CacheEvict(value="Retail_profile", allEntries = true,beforeInvocation = true)
    @PutMapping("/client/updateAddress")
    @ResponseStatus(HttpStatus.OK)
    public void updateAddress(@RequestBody CustomerAddressDTO retailClientAddress) throws Exception {
        retailClientService.updateAddress(retailClientAddress.getAddress(),retailClientAddress.getAuthID());
    }

    @CacheEvict(value="Retail_profile", allEntries = true,beforeInvocation = true)
    @PutMapping("/client/updatePhone")
    @ResponseStatus(HttpStatus.OK)
    public void updatePhone(@RequestBody PhoneDTO phoneDTO){

        retailClientService.updatePhone(phoneDTO.getPhone(),phoneDTO.getAuthID());
    }

    @CacheEvict(value="Retail_profile", allEntries = true,beforeInvocation = true)
    @PutMapping("/client/updatePhotoUrl")
    @ResponseStatus(HttpStatus.OK)
    public void updatePhotoUrl(@RequestBody PhotoDTO photoDTO){
        retailClientService.updatePhotoUrl(photoDTO.getPhotoUrl(),photoDTO.getAuthID());
    }




}
