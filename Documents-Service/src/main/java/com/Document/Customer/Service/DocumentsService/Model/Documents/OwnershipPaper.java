package com.Document.Customer.Service.DocumentsService.Model.Documents;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name="Ownership_Image")
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OwnershipPaper {

    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="authID")
    private String authID;

    @Column(name="email")
    private String email;

    @Column(name="ownership_paper")
    private String ownershipPaper;


}
