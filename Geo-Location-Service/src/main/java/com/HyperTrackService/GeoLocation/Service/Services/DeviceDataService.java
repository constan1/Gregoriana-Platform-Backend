package com.HyperTrackService.GeoLocation.Service.Services;

import com.HyperTrackService.GeoLocation.Model.Nearby;
import com.HyperTrackService.GeoLocation.DTO.NearbyDTO;

public interface DeviceDataService {

    Nearby findNearbyDevices(NearbyDTO nearbyDTO);

}
