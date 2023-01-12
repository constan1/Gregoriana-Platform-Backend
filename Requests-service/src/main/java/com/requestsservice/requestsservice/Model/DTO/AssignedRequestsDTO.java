package com.requestsservice.requestsservice.Model.DTO;

public class AssignedRequestsDTO {
    //Fields: Auth_ID, device_id, driver_email, Merchant_name, PublicTransportRequest

    //Microservices flow. 1. Place Request -->
    // Call request-service(save request to DB) -->
    // call Transport-discover-service ( calcualte nearby driver) ->
    // Pass device_id and email --> -->> (parallel)
    // push notification to phone -> save in assigned requests table.

}
