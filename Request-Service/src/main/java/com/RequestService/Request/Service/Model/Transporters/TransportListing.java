package com.RequestService.Request.Service.Model.Transporters;


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
public class TransportListing {


    @Id
    @Column(name = "id")
    private String email;

    @Column(name= "phoneNumber")
    private Long phoneNumber;

    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name ="vehicle_id")
    private Vehicle vehicle;

    @Column(name="baseRate")
    private Integer baseRate;

    @Column(name="description",length = 140)
    private String description;



}
