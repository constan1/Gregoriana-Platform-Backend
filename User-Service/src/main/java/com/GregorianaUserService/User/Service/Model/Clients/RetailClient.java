package com.GregorianaUserService.User.Service.Model.Clients;


import com.GregorianaUserService.User.Service.Model.Address;
import com.GregorianaUserService.User.Service.Model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name="Retail_Client")
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RetailClient {

    @Id
    @Column(name = "id")
    private String id;


    @Column(name="First_Name")
    private String FirstName;

    @Column(name="Last_Name")
    private String LastName;

    @Column(name="profile_photo")
    private String profile_photo_url;

    @Column(name="phone")
    private Long phone;

    @OneToOne(cascade=CascadeType.MERGE)
    private User user;

    @OneToOne(cascade=CascadeType.ALL)
    private Address address;





}
