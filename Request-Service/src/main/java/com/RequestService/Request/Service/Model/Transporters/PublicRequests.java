package com.RequestService.Request.Service.Model.Transporters;

import com.RequestService.Request.Service.Model.Consumers.AddOn;
import com.RequestService.Request.Service.Model.Consumers.Stop;
import io.azam.ulidj.ULID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity(name="Public_Requests")
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublicRequests {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name= "TrackingNumber")
    private String trackingNumber;

    @Column(name="title")
    private String title;

    @Column(name="date_Stamp")
    private Date dateStamp;

    @OneToOne(cascade = CascadeType.ALL)
    private Stop stops;

    @Column(name="desired_arrival_time")
    private String desired_time_arrival;

    @OneToOne(cascade = CascadeType.ALL)
    private AddOn addOn;


}
