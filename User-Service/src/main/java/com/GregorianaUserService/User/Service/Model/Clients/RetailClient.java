package com.GregorianaUserService.User.Service.Model.Clients;


import com.GregorianaUserService.User.Service.Model.Clients.Address.CustomerAddress;
import com.GregorianaUserService.User.Service.Model.User.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="Retail_Client")
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RetailClient {

    @Id
    @Column(name = "id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="authID")
    private String authID;

    @Column(name="First_Name")
    private String FirstName;

    @Column(name="Last_Name")
    private String LastName;

    @Column(name="profile_photo")
    private String profile_photo_url;

    @Column(name="phone")
    private Long phone;

    @OneToOne(cascade=CascadeType.ALL)
    private User user;

    @OneToOne(cascade=CascadeType.ALL)
    private CustomerAddress address;





}
