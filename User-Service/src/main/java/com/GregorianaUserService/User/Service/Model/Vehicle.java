package com.GregorianaUserService.User.Service.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name="Vehicle_")
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {



    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name="Type")
    private String type;

    @Column(name="Make")
    private String make;

    @Column(name="Year")
    private Integer year;

    @Column(name="Condition")
    private Integer condition;

    @Column(name="Description")
    private String description;

    @Column(name="Capacity")
    private Integer capacity;

    @Column(name="Load")
    private String load;

    @Column(name="License_Plate")
    private String license_plate;

    @Column(name="Photo")
    private String photo_url;

    @OneToOne
    private Address address;


}
