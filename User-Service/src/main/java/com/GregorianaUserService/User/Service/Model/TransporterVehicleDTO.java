package com.GregorianaUserService.User.Service.Model;


import com.GregorianaUserService.User.Service.Model.Clients.TransporterClient;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransporterVehicleDTO {



    private User user;
    private List<Vehicle> transporterclient;

}
