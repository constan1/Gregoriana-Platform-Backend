package com.TransportListingService.TransportListingService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

import javax.persistence.*;

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

    @Column(name = "email")
    private String email;

    @Column(name= "phoneNumber")
    private Long phoneNumber;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name ="vehicles_id")
    private vehicles vehicle;

    @Column(name="description",length = 140)
    private String listing_description;



}
