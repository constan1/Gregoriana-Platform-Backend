package com.GregorianaUserService.User.Service.Resource;



import com.GregorianaUserService.User.Service.Model.*;
import com.GregorianaUserService.User.Service.Model.Clients.TransporterClient;
import com.GregorianaUserService.User.Service.Service.TransporterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserResource {




    private final TransporterService transporterService;



    @PostMapping("/transporterClient")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTransporterClient(@RequestBody TransporterClient transporterClient){

        transporterService.Save_TransporterClient(transporterClient);

    }



    @GetMapping("/transporterInfo")
    @ResponseStatus(HttpStatus.OK)
    public  TransporterClient  getTransporter(@RequestBody TransporterClient transporterClient){

        return transporterService.getTransporter(transporterClient.getAuth_id());

    }

    @PutMapping("/transporterInfo/updateVehicles")
    @ResponseStatus(HttpStatus.OK)
    public void updateTransportersVehicles(@RequestBody TransporterVehicleDTO transporterVehicleDTO){

        TransporterClient transporterClient = new TransporterClient();

        transporterClient.setAuth_id(transporterVehicleDTO.getTransporterClient().getAuth_id());
        transporterClient.setAddress(transporterVehicleDTO.getTransporterClient().getAddress());
        transporterClient.setFullName(transporterVehicleDTO.getTransporterClient().getFullName());
        transporterClient.setPhone(transporterVehicleDTO.getTransporterClient().getPhone());
        transporterClient.setPhoto_url(transporterVehicleDTO.getTransporterClient().getPhoto_url());
        transporterClient.setUser(transporterVehicleDTO.getTransporterClient().getUser());
        transporterClient.setVehicle(transporterVehicleDTO.getVehicle());
        transporterClient.setVerified(transporterVehicleDTO.getTransporterClient().getVerified());

        transporterService.save_or_update_vehicle(transporterClient);

    }

    @PutMapping("/transporterInfo/updateAddress")
    @ResponseStatus(HttpStatus.OK)
    public void updateTransporterAddress(@RequestBody TransporterAddressDTO transporterAddressDTO){

        TransporterClient transporterClient = new TransporterClient();

        transporterClient.setAuth_id(transporterAddressDTO.getTransporterClient().getAuth_id());

        transporterClient.setAddress(transporterAddressDTO.getAddress());

        transporterClient.setFullName(transporterAddressDTO.getTransporterClient().getFullName());

        transporterClient.setPhone(transporterAddressDTO.getTransporterClient().getPhone());

        transporterClient.setPhoto_url(transporterAddressDTO.getTransporterClient().getPhoto_url());

        transporterClient.setUser(transporterAddressDTO.getTransporterClient().getUser());

        transporterClient.setVehicle(transporterAddressDTO.getTransporterClient().getVehicle());

        transporterClient.setVerified(transporterAddressDTO.getTransporterClient().getVerified());

        transporterService.save_or_update_Address(transporterClient);


    }

    @PutMapping("/transporterInfo/updatePhotoUrl")
    @ResponseStatus(HttpStatus.OK)
    public void updateTransporterPhotoUrl(@RequestBody PhotoDTO photoDTO){


        transporterService.updatePhotoUrl(photoDTO.getPhotoUrl(),photoDTO.getAuthID());
    }

    @PutMapping("/transporterInfo/updateVerified")
    @ResponseStatus(HttpStatus.OK)
    public void updateTransporterVerified(@RequestBody VerifiedDTO verifiedDTO){

        transporterService.updateVerified(verifiedDTO.getVerified(),verifiedDTO.getAuthID());
    }

    @PutMapping("/transporterInfo/updatePhone")
    @ResponseStatus(HttpStatus.OK)
    public void updateTransporterPhone(@RequestBody PhoneDTO phoneDTO){
        transporterService.updatePhone(phoneDTO.getPhone(),phoneDTO.getAuthID());
    }


}
