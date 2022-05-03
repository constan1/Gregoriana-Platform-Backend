package com.GregorianaUserService.User.Service.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name="vehicle_photos")
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiclePhotos {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "first_photo")
    private String first_photo_url;

    @Column(name="second_photo")
    private String second_photo_url;

    @Column(name="third_photo")
    private String third_photo_url;







}
