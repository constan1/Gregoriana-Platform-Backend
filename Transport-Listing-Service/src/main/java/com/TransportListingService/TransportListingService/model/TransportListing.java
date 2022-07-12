package com.TransportListingService.TransportListingService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

import javax.persistence.*;
import java.util.Date;

@Entity(name="Transport_Listing")
@Table(name="transportListing")
@OptimisticLocking(type = OptimisticLockType.DIRTY)
@DynamicUpdate
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

//This will be used as metadata for hypertrak devices
public class TransportListing {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "authID")
    private String authID;

    @Column(name = "email")
    private String email;

    @Column(name= "phoneNumber")
    private Long phoneNumber;

    //This is for when the transporter cancels an active trip - He will be unavailable for 2 hours
    // His device will not be able to be tracked for 2 hours.
    @Column(name = "unavailableUntil")
    private Date unavailableUntil;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name ="vehicles_id")
    private vehicles vehicle;

}
