package com.GregorianaUserService.User.Service.Model.DTO;


import com.GregorianaUserService.User.Service.Model.Vehicles.Vehicle;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransporterVehicleDTO {



    private String authID;
    private Long id;
    private Vehicle vehicle;


}
