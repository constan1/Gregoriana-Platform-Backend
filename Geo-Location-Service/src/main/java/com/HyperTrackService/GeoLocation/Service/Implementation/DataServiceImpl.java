package com.HyperTrackService.GeoLocation.Service.Implementation;


import com.HyperTrackService.GeoLocation.Model.Nearby;
import com.HyperTrackService.GeoLocation.DTO.NearbyDTO;
import com.HyperTrackService.GeoLocation.Service.Services.DeviceDataService;
import com.HyperTrackService.GeoLocation.apiProxy.NearByDeviceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class DataServiceImpl implements DeviceDataService {

    @Autowired private NearByDeviceProxy nearByDeviceProxy;

    @Override
    public Nearby findNearbyDevices(NearbyDTO nearbyDTO) {
        return nearByDeviceProxy.responseData(nearbyDTO);
    }

}
