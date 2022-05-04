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
    public void createTransporterClient(@RequestBody TransporterClient transporterClient){

        transporterService.Save_TransporterClient(transporterClient);

    }



    @GetMapping("/client")
    @ResponseStatus(HttpStatus.OK)
    public  TransporterClient  getTransporter(@RequestBody ClientDTO clientDTO){

        return transporterService.getTransporter(clientDTO.getAuthID());

    }

    @PutMapping("/client/updateVehicle")
    @ResponseStatus(HttpStatus.OK)
    public void updateTransportersVehicles(@RequestBody TransporterVehicleDTO transporterVehicleDTO){

        transporterService.updateVehicle(transporterVehicleDTO.getVehicle().getType(),
                transporterVehicleDTO.getVehicle().getMake(),
                transporterVehicleDTO.getVehicle().getYear(),
                transporterVehicleDTO.getVehicle().getCondition(),
                transporterVehicleDTO.getVehicle().getDescription(),
                transporterVehicleDTO.getVehicle().getCapacity(),
                transporterVehicleDTO.getVehicle().getLoad(),
                transporterVehicleDTO.getVehicle().getLicense_plate(),
                transporterVehicleDTO.getVehicle().getOwnership_paper(),
                transporterVehicleDTO.getVehicle().getFirst_photo_url(),
                transporterVehicleDTO.getVehicle().getSecond_photo_url(),
                transporterVehicleDTO.getVehicle().getThird_photo_url(),
                transporterVehicleDTO.getAuthID());
    }

    @PutMapping("/client/updateAddress")
    @ResponseStatus(HttpStatus.OK)
    public void updateTransporterAddress(@RequestBody AddressDTO transporterAddressDTO){

        transporterService.updateAddress(transporterAddressDTO.getAddress().getCountry(), transporterAddressDTO.getAddress().getStreet_address(),
                transporterAddressDTO.getAddress().getCity(),transporterAddressDTO.getAddress().getProvince(), transporterAddressDTO.getAddress().getPostal_code(),transporterAddressDTO.getAuthID());
    }

    @PutMapping("/client/updatePhotoUrl")
    @ResponseStatus(HttpStatus.OK)
    public void updateTransporterPhotoUrl(@RequestBody PhotoDTO photoDTO){


        transporterService.updatePhotoUrl(photoDTO.getPhotoUrl(),photoDTO.getAuthID());
    }

    @PutMapping("/client/updateVerified")
    @ResponseStatus(HttpStatus.OK)
    public void updateTransporterVerified(@RequestBody VerifiedDTO verifiedDTO){

        transporterService.updateVerified(verifiedDTO.getVerified(),verifiedDTO.getAuthID());
    }

    @PutMapping("/client/updatePhone")
    @ResponseStatus(HttpStatus.OK)
    public void updateTransporterPhone(@RequestBody PhoneDTO phoneDTO){
        transporterService.updatePhone(phoneDTO.getPhone(),phoneDTO.getAuthID());
    }




}
