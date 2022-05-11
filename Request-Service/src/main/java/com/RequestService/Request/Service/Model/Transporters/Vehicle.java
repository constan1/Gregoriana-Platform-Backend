package com.RequestService.Request.Service.Model.Transporters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name="Vehicle")
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

    @Column(name = "type")
    private String type;

    @Column(name = "year")
    private Integer year;

    @Column(name = "condition")
    private Integer condition;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name="load")
    private String Load;

    @Column(name = "licensePlate")
    private String license_plate;

    @Column(name = "first_photo")
    private String first_photo_url;

    @Column(name = "second_photo")
    private String second_photo_url;

    @Column(name = "third_photo")
    private String third_photo_url;
}
