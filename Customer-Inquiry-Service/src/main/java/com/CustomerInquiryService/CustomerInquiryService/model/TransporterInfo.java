package com.CustomerInquiryService.CustomerInquiryService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

import javax.persistence.*;


@Entity(name="Transport_Info")
@Table(name="transportInfo")
@OptimisticLocking(type = OptimisticLockType.DIRTY)
@DynamicUpdate
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransporterInfo {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name= "phoneNumber")
    private Long phoneNumber;

    @Column(name="baseRate")
    private Integer baseRate;

    @Column(name = "profile_image")
    private String profileImage;


}
