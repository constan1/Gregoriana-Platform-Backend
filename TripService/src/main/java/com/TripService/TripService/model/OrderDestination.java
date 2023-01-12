package com.TripService.TripService.model;

import lombok.Data;

@Data
public class OrderDestination {


    private OrdersGeometry geometry;
    private Integer radius;
}
