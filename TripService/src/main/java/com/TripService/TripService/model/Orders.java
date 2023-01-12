package com.TripService.TripService.model;

import lombok.Data;

@Data
public class Orders {

    private String order_id;
    private OrderDestination destination;
    private OrdersMetadata metadata;
}
