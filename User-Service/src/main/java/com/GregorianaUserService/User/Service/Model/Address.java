package com.GregorianaUserService.User.Service.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name="Address_")
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="Country")
    private String country;

    @Column(name="Street_Address")
    private String street_address;

    @Column(name="City")
    private String City;

    @Column(name="province")
    private String province;

    @Column(name="postal_code")
    private String postal_code;

    @Column(name="Address_lat")
    private Long address_lat;

    @Column(name="Address_long")
    private Long address_long;


}
