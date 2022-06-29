package com.Document.Customer.Service.DocumentsService.Model.Documents;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name="Drivers_License_Image")
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DriversLicense {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="authID")
    private String authID;

    @Column(name = "email")
    private String email;


    @Column(name = "drivers_License")
    private String driversLicense;




}
