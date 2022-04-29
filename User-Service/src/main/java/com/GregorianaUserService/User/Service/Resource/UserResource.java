package com.GregorianaUserService.User.Service.Resource;



import com.GregorianaUserService.User.Service.Model.Clients.TransporterClient;
import com.GregorianaUserService.User.Service.Model.TransporterVehicleDTO;
import com.GregorianaUserService.User.Service.Model.User;
import com.GregorianaUserService.User.Service.Service.TransporterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserResource {




    private final TransporterService transporterService;



    @PostMapping("/transporterClient")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTransporterClient(@RequestBody TransporterClient transporterClient){

        transporterService.Save_TransporterClient(transporterClient);

    }



    @GetMapping("/transporterInfo")
    @ResponseStatus(HttpStatus.OK)
    public  TransporterClient  getTransporter(@RequestBody User user_){

        return transporterService.getTransporter(user_.getAuth_id());
    }

    @PutMapping("/transporterInfo/updateVehicles")
    @ResponseStatus(HttpStatus.OK)
    public void updateTransportersVehicles(@RequestBody TransporterVehicleDTO transporterClientDTO){


        TransporterClient transporterClient_ = new TransporterClient();

        transporterClient_.setTotal_vehicles(transporterClientDTO.getTransporterclient());

        transporterClient_.setUser(transporterClientDTO.getUser());

        transporterService.updateVehicles(transporterClient_.getTotal_vehicles(),transporterClient_.getUser().getAuth_id());

    }


}
