package com.AddressService.AddressService.resource;


import com.AddressService.AddressService.AES.PBK2;
import com.AddressService.AddressService.model.Addresses.CompanyAddress;
import com.AddressService.AddressService.service.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/companyAddress")
@RequiredArgsConstructor
public class CompanyAddressResource {

    private final AddressService addressService;


    @PostMapping("/saveAddress")
    private void saveCompanyAddress(@RequestBody CompanyAddress companyAddress) throws Exception {

        addressService.saveBusinessAddress(companyAddress);
    }

    @GetMapping("/getAddress/{authID}")
    private CompanyAddress getCompanyAddress(@PathVariable(name = "authID") String authID) throws Exception {


        return addressService.getBusinessAddress(authID);
    }


}
