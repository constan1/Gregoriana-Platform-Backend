package com.RequestService.Request.Service.Model.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestStatusDTO {

    private String trackingNumber;
    private String Status;
}
