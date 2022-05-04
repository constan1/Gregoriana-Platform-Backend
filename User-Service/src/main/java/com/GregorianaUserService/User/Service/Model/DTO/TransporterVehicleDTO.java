package com.GregorianaUserService.User.Service.Model.DTO;


import com.GregorianaUserService.User.Service.Model.Clients.TransporterClient;
import com.GregorianaUserService.User.Service.Model.Vehicle;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransporterVehicleDTO {



    private String authID;
    private Vehicle vehicle;


}
