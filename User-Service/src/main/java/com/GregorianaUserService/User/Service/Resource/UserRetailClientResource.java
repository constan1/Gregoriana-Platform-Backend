package com.GregorianaUserService.User.Service.Resource;


import com.GregorianaUserService.User.Service.Model.Clients.RetailClient;
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
    public void createRetailClient(@RequestBody RetailClient retailClient) throws Exception {

        retailClientService.save_Retail_Client(retailClient);
    }

    @RequestMapping(value = "/client/{authID}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public RetailClient getRetailClient(@PathVariable(name ="authID") String authID) throws Exception {
        return retailClientService.getRetailClient(authID);
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
