package com.RequestService.Request.Service.Model.Consumers.privateRequest;

import com.RequestService.Request.Service.Model.Consumers.privateRequest.DropOffs;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity(name="Stops")
@Table(name="stop")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Stop {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "From_Address_title")
    private String fromAddressTitle;

    @Column(name = "From_Address_Lat")
    private Float fromAddressLat;

    @Column(name ="From_Address_Long")
    private Float fromAddressLong;

    @Column(name = "notes_Description",length = 300)
    private String notesDescription;

    @Column(name ="photoUrl")
    private String photoUrl;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name ="drop_off_id")
    private List<DropOffs> dropOffs;


}
