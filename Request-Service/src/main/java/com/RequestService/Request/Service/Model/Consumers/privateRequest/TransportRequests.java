package com.RequestService.Request.Service.Model.Consumers.privateRequest;


import com.RequestService.Request.Service.Model.Consumers.privateRequest.AddOn;
import com.RequestService.Request.Service.Model.Consumers.privateRequest.Stop;
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

    @Column(name="authID")
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
    @JoinColumn(name ="addOn")
    private AddOn addOn;





}
