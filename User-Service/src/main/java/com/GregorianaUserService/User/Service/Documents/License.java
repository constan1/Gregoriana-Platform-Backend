package com.GregorianaUserService.User.Service.Documents;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity(name="Documents_Drivers_License")
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class License implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="authID")
    private String authID;

    @Column(name = "photo_url")
    private String drivers_photo_url;

}
