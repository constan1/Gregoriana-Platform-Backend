package com.GregorianaUserService.User.Service.Model.Clients;



import com.GregorianaUserService.User.Service.Model.User.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity(name="Transporter_Client")
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransporterClient {


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
    private User user;




}
