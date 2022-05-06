package com.GregorianaUserService.User.Service.Model.DTO.AddressDTO;


import com.GregorianaUserService.User.Service.Model.Clients.Address.CustomerAddress;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerAddressDTO {

    private String authID;
    private CustomerAddress address;
}
