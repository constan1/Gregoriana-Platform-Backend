package com.HyperTrackService.GeoLocation.DTO;

import lombok.*;


@Data
public class NearbyDTO {

    //remaining distance - distance <=5km
    private orderDTO order;
    private String search_type;
    private searchFilterDTO search_filter;
}
