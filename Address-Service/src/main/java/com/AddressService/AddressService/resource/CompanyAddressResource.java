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

        companyAddress.setStreet(PBK2.encrypt(companyAddress.getStreet()));

        companyAddress.setPostalCode(PBK2.encrypt(companyAddress.getPostalCode()));

        addressService.saveBusinessAddress(companyAddress);
    }

    @GetMapping("/getAddress/{authID}")
    private CompanyAddress getCompanyAddress(@PathVariable(name = "authID") String authID) throws Exception {

        CompanyAddress companyAddress = addressService.getBusinessAddress(authID);


         if(companyAddress.getStreet()!=null && companyAddress.getPostalCode()!=null){
            companyAddress.setStreet(PBK2.decrypt(companyAddress.getStreet()));
            companyAddress.setPostalCode(PBK2.decrypt(companyAddress.getPostalCode()));

            return companyAddress;
        }
        else if(companyAddress.getStreet()!=null){
            companyAddress.setStreet(PBK2.decrypt(companyAddress.getStreet()));

            return  companyAddress;
        }
        else if(companyAddress.getPostalCode()!=null) {
            companyAddress.setPostalCode(PBK2.decrypt(companyAddress.getPostalCode()));
           return companyAddress;
        }
        else {
            return companyAddress;
         }
    }



}
