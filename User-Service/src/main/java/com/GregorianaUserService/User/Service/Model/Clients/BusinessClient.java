package com.GregorianaUserService.User.Service.Model.Clients;



import com.GregorianaUserService.User.Service.Model.User.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="Business_Client")
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BusinessClient {

    @Id
    @Column(name = "id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="authID")
    private String authID;

    @Column(name="Company_name")
    private String company_name;

    @Column(name="Phone")
    private Long phone_num;

    @Column(name="Photo_Url")
    private String profile_photo_url;

    @OneToOne(cascade=CascadeType.ALL)
    private User user;

}
