package com.GregorianaUserService.User.Service.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity(name="Vehicle_")
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle implements Serializable {



    @Id
    @Column(name = "id")
    private String id;


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

    @Column(name="Ownership_Paper_Url")
    private String ownership_paper;

    @Column(name = "first_photo")
    private String first_photo_url;

    @Column(name="second_photo")
    private String second_photo_url;

    @Column(name="third_photo")
    private String third_photo_url;





}
