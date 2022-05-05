package com.GregorianaUserService.User.Service.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.micrometer.core.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.management.relation.Role;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name="User_")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @Column(name="id")
    private String id;

    @OneToOne
    private Roles role;

    @Column(name="user_email")
    private String email;








}
