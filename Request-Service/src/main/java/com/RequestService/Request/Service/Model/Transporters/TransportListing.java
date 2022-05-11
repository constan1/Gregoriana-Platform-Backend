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
public class TransportListing implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="authID")
    private String authID;

    @OneToOne( cascade =  CascadeType.ALL)
    private Vehicle vehicle;

    @Column(name="Base_Rate")
    private Integer baseRate;

    @Column(name="Description")
    private String description;



}
