package com.RequestService.Request.Service.Model.Transporters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name="Transporters_Inquiries")
@Table(name = "transportInquiries")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransportInquiries {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name= "TrackingNumber")
    private String referenceTrackingNumber;



}
