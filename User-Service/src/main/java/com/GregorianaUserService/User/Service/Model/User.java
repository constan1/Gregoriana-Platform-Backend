package com.GregorianaUserService.User.Service.Model;


import io.micrometer.core.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.management.relation.Role;
import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="User_")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name="auth_id")
    private String auth_id;



    @OneToOne
    private Roles role;

    @Column(name="user_email")
    private String email;

    @Column(name="date_joined")
    @Temporal(TemporalType.DATE)
    private Date date_joined;









}
