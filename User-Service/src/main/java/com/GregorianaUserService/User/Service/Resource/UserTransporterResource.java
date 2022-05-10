package com.GregorianaUserService.User.Service.Resource;


import com.GregorianaUserService.User.Service.Model.Clients.TransporterClient;
import com.GregorianaUserService.User.Service.Model.DTO.*;
import com.GregorianaUserService.User.Service.Model.DTO.AddressDTO.TransporterAddressDTO;
import com.GregorianaUserService.User.Service.Service.Services.TransporterService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/v1/user/transporter")
@RequiredArgsConstructor
public class UserTransporterResource {


    private final TransporterService transporterService;


    @CacheEvict(value="transporter_profile", allEntries = true,beforeInvocation = true)
    @PostMapping("/client")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTransporterClient(@RequestBody TransporterClient transporterClient) throws Exception {


        transporterService.Save_TransporterClient(transporterClient);
    }

    @Cacheable("transporter_profile")
    @GetMapping("/client")
    @ResponseStatus(HttpStatus.OK)
    public  TransporterClient  getTransporter(@RequestBody ClientDTO clientDTO) throws Exception {

        return transporterService.getTransporter(clientDTO.getAuthID());

    }


    @CacheEvict(value="transporter_profile", allEntries = true,beforeInvocation = true)
    @PutMapping("/client/updateAddress")
    @ResponseStatus(HttpStatus.OK)
    public void updateTransporterAddress(@RequestBody TransporterAddressDTO transporterAddressDTO) throws Exception {

        transporterService.updateAddress(transporterAddressDTO
                .getAddress(),transporterAddressDTO.getAuthID());

    }
    @CacheEvict(value="transporter_profile", allEntries = true,beforeInvocation = true)
    @PutMapping("/client/updatePhotoUrl")
    @ResponseStatus(HttpStatus.OK)
    public void updateTransporterPhotoUrl(@RequestBody PhotoDTO photoDTO){

        transporterService.updatePhotoUrl(photoDTO.getPhotoUrl(),photoDTO.getAuthID());
    }
    @CacheEvict(value="transporter_profile", allEntries = true)
    @PutMapping("/client/updateVerified")
    @ResponseStatus(HttpStatus.OK)
    public void updateTransporterVerified(@RequestBody VerifiedDTO verifiedDTO) {

        transporterService.updateVerified(verifiedDTO.getVerified(),verifiedDTO.getAuthID());
    }
    @CacheEvict(value="transporter_profile", allEntries = true,beforeInvocation = true)
    @PutMapping("/client/updatePhone")
    @ResponseStatus(HttpStatus.OK)
    public void updateTransporterPhone(@RequestBody PhoneDTO phoneDTO){
        transporterService.updatePhone(phoneDTO.getPhone(),phoneDTO.getAuthID());
    }

    @CacheEvict(value="transporter_profile", allEntries = true,beforeInvocation = true)
    @PutMapping("/client/updateDriversLicense")
    @ResponseStatus(HttpStatus.OK)
    public void updateDriversLicense(@RequestBody LicenseDTO license) throws Exception {
        transporterService.updateLicensePhoto(license.getDrivers_license().getDrivers_photo_url(),license.getAuthID());
    }





}