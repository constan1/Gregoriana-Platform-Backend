package com.requestsservice.requestsservice.Model.DTO;


import com.requestsservice.requestsservice.Model.AddOn;
import com.requestsservice.requestsservice.Model.Stop;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class publicTransportRequestsDTO {


    private String title;
    private String trackingNumber;
    private Date dateStamp;
    private Stop stops;
    private String desired_time_arrival;
    private AddOn addOn;
    private String vehicleTypeNeeded;

}
