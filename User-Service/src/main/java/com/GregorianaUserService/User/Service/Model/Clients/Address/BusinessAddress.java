package com.GregorianaUserService.User.Service.Model.Clients.Address;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="Business_Address")
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BusinessAddress implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="authID")
    private String authID;

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
}
