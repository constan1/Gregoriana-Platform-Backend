package com.GregorianaUserService.User.Service.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity(name="Address_")
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name="Country")
    private String country;

    @Column(name="Street_Address")
    private String street_address;

    @Column(name="City")
    private String City;

    @Column(name="province")
    private String province;

    @Column(name="postal_code")
    private String postal_code;

}
