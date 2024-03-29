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
    private String company_address_country;

    @Column(name = "province")
    private String company_address_province;

    @Column(name = "city")
    private String company_address_city;

    @Column(name = "street_address")
    private String company_address_street;

    @Column(name = "postal_code")
    private String company_address_postalCode;



}
