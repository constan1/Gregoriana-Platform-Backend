package com.RequestService.Request.Service.Model.Consumers;


import com.RequestService.Request.Service.Model.Transporters.TransportListing;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;


import javax.persistence.*;
import java.util.Date;

@Entity(name="Consumers_Inquiries")
@Table(name ="consumerInquiries")
@OptimisticLocking(type = OptimisticLockType.DIRTY)
@DynamicUpdate
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
    private Date dateTimeStamp;

    @OneToOne(cascade = CascadeType.ALL)
    private TransportListing transportListing;



}
