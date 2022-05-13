package com.RequestService.Request.Service.Model.Transporters;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="Transport_Listing")
@Table
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
    private Vehicle vehicle;

    @Column(name="baseRate")
    private Integer baseRate;

    @Column(name="description",length = 140)
    private String description;



}
