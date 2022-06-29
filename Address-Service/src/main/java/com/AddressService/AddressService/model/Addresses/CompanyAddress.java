package com.AddressService.AddressService.model.Addresses;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name="Business_Address")
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CompanyAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name="authID")
    private String authID;


    @Column(name = "country")
    private String country;

    @Column(name = "province")
    private String province;

    @Column(name = "city")
    private String city;

    @Column(name = "street_address")
    private String street;

    @Column(name = "postal_code")
    private String postalCode;



}
