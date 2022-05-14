package com.RequestService.Request.Service.Model.Consumers.privateRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name="DropOffs")
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DropOffs {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="drop_Address_title")
    private String dropAddressTitle;

    @Column(name ="drop_Address_Lat")
    private Float dropAddressLat;

    @Column(name ="drop_Address_Long")
    private Float dropAddressLong;


}
