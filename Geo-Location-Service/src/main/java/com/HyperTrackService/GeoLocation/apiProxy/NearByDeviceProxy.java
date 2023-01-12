package com.HyperTrackService.GeoLocation.apiProxy;

import com.HyperTrackService.GeoLocation.config.FeignClientConfig;
import com.HyperTrackService.GeoLocation.Model.Nearby;
import com.HyperTrackService.GeoLocation.DTO.NearbyDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "nearby-api", configuration = FeignClientConfig.class, url = "https://v3.api.hypertrack.com/nearby/v3")
public interface NearByDeviceProxy {

    @RequestMapping(method = RequestMethod.POST)
    Nearby responseData(@RequestBody NearbyDTO nearbyDTO);


}
//https://codingnconcepts.com/spring-boot/configure-feign-rest-client/#:~:text=FeignClient%20is%20a%20Declarative%20REST%20Client%20in%20Spring,RESTFul%20API%20endpoints%20exposed%20by%20thirdparty%20or%20microservice.