package com.HyperTrackService.GeoLocation.DTO;

import com.HyperTrackService.GeoLocation.DTO.locationDTO;
import lombok.*;


@Data
public class NearbyDTO {

    private locationDTO location;
    private Integer radius;
}
