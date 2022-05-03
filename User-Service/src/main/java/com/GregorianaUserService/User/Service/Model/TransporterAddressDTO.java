package com.GregorianaUserService.User.Service.Model;


import com.GregorianaUserService.User.Service.Model.Clients.TransporterClient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransporterAddressDTO {

    private TransporterClient transporterClient;

    private Address address;
}
