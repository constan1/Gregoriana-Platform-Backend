package com.RequestService.Request.Service.Model.Transporters;


import com.RequestService.Request.Service.Model.Consumers.privateRequest.TransportRequests;
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

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    private TransportRequests transportRequests;

    @Column(name="date_Stamp")
    private Date dateOfCompletion;


}
