package com.GregorianaUserService.User.Service.Model.Clients;


import com.GregorianaUserService.User.Service.Model.Address;
import com.GregorianaUserService.User.Service.Model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name="Business_Client")
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BusinessClient {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name="Cname")
    private String name;

    @Column(name="Phone")
    private Long phone_num;

    @Column(name="Photo_Url")
    private String url;

    @OneToOne
    private User user;

    @OneToOne
    private Address address;

}
