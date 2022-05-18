package com.RequestService.Request.Service.Model.LoggingService;


import com.RequestService.Request.Service.Model.Consumers.privateRequest.TransportRequests;
import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestHistory {

    private Long id;


    private String signatureUrl;

    private TransportRequests transportRequests;

    private Date dateOfCompletion;


}
