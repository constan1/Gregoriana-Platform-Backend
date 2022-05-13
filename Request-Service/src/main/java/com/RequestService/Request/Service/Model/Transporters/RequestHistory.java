package com.RequestService.Request.Service.Model.Transporters;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity(name="Request_History")
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestHistory {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "signutreUrl")
    private String signatureUrl;

    @Column(name= "TrackingNumber")
    private String trackingNumber;

    @Column(name="date_Stamp")
    private Date dateOfCompletion;


}
