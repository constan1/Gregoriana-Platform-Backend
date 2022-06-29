package com.AddressService.AddressService.resource;


import com.AddressService.AddressService.model.Addresses.TransporterAddress;
import com.AddressService.AddressService.service.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/transportersAddress")
@RequiredArgsConstructor
public class TransporterAddressResource {

    private final AddressService addressService;


    @PostMapping("/saveAddress")
    private void saveTransportAddress(@RequestBody TransporterAddress transporterAddress){

        addressService.saveTransporterAddress(transporterAddress);
    }


    @GetMapping("/getAddress/{authID}")
    private TransporterAddress getTransportAddress(@PathVariable(name = "authID") String authID){

        return addressService.getTransporterAddress(authID);
    }
}
