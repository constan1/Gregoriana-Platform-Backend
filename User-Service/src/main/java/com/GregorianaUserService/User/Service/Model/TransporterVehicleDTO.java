package com.GregorianaUserService.User.Service.Model;


import com.GregorianaUserService.User.Service.Model.Clients.TransporterClient;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransporterVehicleDTO {



    private TransporterClient transporterClient;
    private Vehicle vehicle;


}
