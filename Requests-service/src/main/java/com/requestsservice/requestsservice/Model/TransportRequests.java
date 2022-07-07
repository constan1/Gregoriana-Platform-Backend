package com.requestsservice.requestsservice.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

import javax.persistence.*;
import java.util.Date;


@Entity(name="Transport_Requests")
@Table(name = "TransportRequests")
@OptimisticLocking(type = OptimisticLockType.DIRTY)
@DynamicUpdate
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransportRequests {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String authID;

    @Column(name="title")
    private String title;

    @Column(name="tracking_Number")
    private String trackingNumber;

    @Column(name="date_Stamp")
    private Date dateStamp;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name ="stop_id")
    private Stop stops;

    @Column(name="desired_arrival_time")
    private String desired_time_arrival;

    @Column(name="request_Status")
    private String status;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name ="addOn_id")
    private AddOn addOn;

    @Column(name = "vehicle_type_needed")
    private String vehicleTypeNeeded;

    @Column(name = "profile_Image")
    private String supplier_profile; //will call the user service to obtain this. we will use circuitbreaker resiliance 4j pattern.



}
