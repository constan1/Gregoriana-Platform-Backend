package com.GregorianaUserService.User.Service.Model.DTO;


import com.GregorianaUserService.User.Service.Model.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDTO {

    private String authID;

    private Address address;
}
