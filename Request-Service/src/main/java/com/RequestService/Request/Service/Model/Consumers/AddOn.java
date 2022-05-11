package com.RequestService.Request.Service.Model.Consumers;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name="AddOn")
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddOn {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "HelperAddon")
    private Integer helperAddon;

    @Column(name = "Exclusive")
    private Boolean exclusive;
}
