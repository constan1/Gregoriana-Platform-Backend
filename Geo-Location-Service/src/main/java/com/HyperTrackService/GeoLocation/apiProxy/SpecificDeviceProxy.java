package com.HyperTrackService.GeoLocation.apiProxy;


import com.HyperTrackService.GeoLocation.Model.Device;
import com.HyperTrackService.GeoLocation.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "specificDevice-api", configuration = FeignClientConfig.class, url = "https://v3.api.hypertrack.com/devices")
public interface SpecificDeviceProxy {

    @GetMapping("{deviceID}")
    Device responseDevice(@PathVariable String deviceID);


}
