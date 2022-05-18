package com.RequestService.Request.Service.Model.Consumers;


import com.RequestService.Request.Service.Model.Transporters.TransportListing;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@Entity(name="Consumers_Inquiries")
@Table(name ="consumerInquiries")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConsumersInquiries {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="trackingNumber")
    private String trackingNumber;

    @Column(name ="dateCreated")
    private String dateTimeStamp;

    @OneToOne(cascade = CascadeType.ALL)
    private TransportListing transportListing;



}
