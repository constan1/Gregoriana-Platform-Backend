package com.GregorianaUserService.User.Service.Model.subscription;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name="subsciption")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
/**
 * This table can only be read from by users. CLIENT - PERMISSION - READ ONLY.  ADMIN PERMISSION - ALL.
 * This API calls this table for the subscription field.
 */
public class Subscription {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "authID")
    private String authID;

    @Column(name = "subscription")
    private String subscription;

}
