package com.RequestService.Request.Service.Model.Consumers;

import com.RequestService.Request.Service.Model.Transporters.TransportListing;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name="Transport_Requests")
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransportRequests {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="authID")
    private String authID;

    @Column(name="title")
    private String title;

    @Column(name="tracking_Number")
    private String trackingNumber;

    @Column(name="date_Stamp")
    private Date dateStamp;

    @OneToOne(cascade = CascadeType.ALL)
    private Stop stops;

    @Column(name="total_Distance")
    private Float totalDistance;

    @Column(name="desired_arrival_time")
    private Date desired_time_arrival;

    @Column(name="request_Status")
    private String status;

    @OneToMany(cascade = CascadeType.ALL)
    private List<TransportListing> inquirers;

    @OneToOne(cascade = CascadeType.ALL)
    private AddOn addOn;





}
