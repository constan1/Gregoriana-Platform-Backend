package com.HyperTrackService.GeoLocation.Resource;


import com.HyperTrackService.GeoLocation.Model.Device;
import com.HyperTrackService.GeoLocation.Model.Nearby;
import com.HyperTrackService.GeoLocation.DTO.NearbyDTO;
import com.HyperTrackService.GeoLocation.Service.Services.DeviceDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
public class NearbyResources {


    @Autowired private DeviceDataService deviceDataService;

    @PostMapping("/data")
    @ResponseStatus(HttpStatus.OK)
    public Nearby getData(@RequestBody NearbyDTO nearbyDTO){
       return deviceDataService.findNearbyDevices(nearbyDTO);
    }

    @GetMapping("/data/{deviceID}")
    @ResponseStatus(HttpStatus.OK)
    public Device getSpecificDevice(@PathVariable String deviceID){
        return deviceDataService.findSpecificDevice(deviceID);
    }
}
