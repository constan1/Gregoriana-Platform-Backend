package com.GregorianaUserService.User.Service.Model.DTO.AddressDTO;


import com.GregorianaUserService.User.Service.Model.Clients.Address.TransporterAddress;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransporterAddressDTO {

    private String authID;
    private TransporterAddress address;

}
