package com.GregorianaUserService.User.Service.Model.DTO.AddressDTO;


import com.GregorianaUserService.User.Service.Model.Clients.Address.BusinessAddress;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BusinessAddressDTO {

    private String authID;
    private BusinessAddress address;
}
