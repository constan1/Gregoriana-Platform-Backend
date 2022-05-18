package com.RequestService.Request.Service.Model.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class RequestCompletedDTO {

    private String trackingNumber;
    private String signatureUrl;
}
