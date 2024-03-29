package com.GregorianaUserService.User.Service.Resource;


import com.GregorianaUserService.User.Service.Model.Clients.TransporterClient;
import com.GregorianaUserService.User.Service.Model.DTO.*;
import com.GregorianaUserService.User.Service.Service.Services.TransporterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/v1/user/transporter")
@RequiredArgsConstructor
public class UserTransporterResource {


    private final TransporterService transporterService;



    @PostMapping("/client")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTransporterClient(@RequestBody TransporterClient transporterClient) throws Exception {


        transporterService.Save_TransporterClient(transporterClient);
    }


    @GetMapping("/client/{authID}")
    @ResponseStatus(HttpStatus.OK)
    public  TransporterClient  getTransporter(@PathVariable("authID") String authID) throws Exception {

        return transporterService.getTransporter(authID);

    }

    @PutMapping("/client/updatePhotoUrl")
    @ResponseStatus(HttpStatus.OK)
    public void updateTransporterPhotoUrl(@RequestBody PhotoDTO photoDTO){

        transporterService.updatePhotoUrl(photoDTO.getPhotoUrl(),photoDTO.getAuthID());
    }
    @PutMapping("/client/updateVerified")
    @ResponseStatus(HttpStatus.OK)
    public void updateTransporterVerified(@RequestBody VerifiedDTO verifiedDTO) {

        transporterService.updateVerified(verifiedDTO.getVerified(),verifiedDTO.getAuthID());
    }
    @PutMapping("/client/updatePhone")
    @ResponseStatus(HttpStatus.OK)
    public void updateTransporterPhone(@RequestBody PhoneDTO phoneDTO){
        transporterService.updatePhone(phoneDTO.getPhone(),phoneDTO.getAuthID());
    }






}
