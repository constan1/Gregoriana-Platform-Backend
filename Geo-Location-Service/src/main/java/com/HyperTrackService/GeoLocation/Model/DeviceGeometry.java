package com.HyperTrackService.GeoLocation.Model;

import lombok.Data;

import java.io.Serializable;

@Data
public class DeviceGeometry {

    private String type;
    private float [] coordinates;

}
