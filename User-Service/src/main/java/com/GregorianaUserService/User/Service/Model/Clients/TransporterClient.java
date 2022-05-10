package com.GregorianaUserService.User.Service.Model.Clients;


import com.GregorianaUserService.User.Service.Documents.License;
import com.GregorianaUserService.User.Service.Model.Clients.Address.TransporterAddress;
import com.GregorianaUserService.User.Service.Model.User.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity(name="Transporter_Client")
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransporterClient implements Serializable {


    @Id
    @Column(name = "id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="authID")
    private String authID;

    @Column(name="Full_Name")
    private String fullName;

    @Column(name="Phone")
    private Long phone;

    @Column(name="Verify")
    private Boolean verified;

    @Column(name="Profile_Photo_Url")
    private String photo_url;

    @OneToOne(cascade=CascadeType.ALL)
    private TransporterAddress address;

    @OneToOne(cascade=CascadeType.ALL)
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    private License drivers_license;



}
