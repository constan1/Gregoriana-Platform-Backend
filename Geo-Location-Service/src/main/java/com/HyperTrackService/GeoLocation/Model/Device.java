package com.HyperTrackService.GeoLocation.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Device {


    private String device_id;
    private Status status;

    private Info info;
}
