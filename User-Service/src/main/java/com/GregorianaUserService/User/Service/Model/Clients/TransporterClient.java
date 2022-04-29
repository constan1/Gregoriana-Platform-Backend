package com.GregorianaUserService.User.Service.Model.Clients;


import com.GregorianaUserService.User.Service.Model.Address;
import com.GregorianaUserService.User.Service.Model.User;
import com.GregorianaUserService.User.Service.Model.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name="Transporter_Client")
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransporterClient {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="Full_Name")
    private String fullname;

    @Column(name="Phone")
    private Long phone;

    @Column(name="Verify")
    private Boolean verified;

    @Column(name="Profile_Photo_Url")
    private String photo_url;

    @OneToOne(cascade=CascadeType.ALL)
    private Vehicle selected_vehicle;

    @OneToOne(cascade=CascadeType.ALL)
    private Address address;

    @OneToOne(cascade=CascadeType.ALL)
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Vehicle> total_vehicles;



}
