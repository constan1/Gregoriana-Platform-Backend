package com.FeedbackRatingService.Feedback.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="vehicles")
@Table(name="vehicles")
@OptimisticLocking(type = OptimisticLockType.DIRTY)
@DynamicUpdate
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class vehicles {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String vehicle_type;

    @Column(name = "year")
    private Integer vehicle_year;

    @Column(name = "condition")
    private Integer vehicle_condition;

    @Column(name = "capacity")
    private Integer vehicle_capacity;

    @Column(name="load")
    private String vehicle_Load;

    @Column(name = "licensePlate")
    private String vehicle_license_plate;

    @Column(name = "first_photo")
    private String vehicle_first_photo_url;

    @Column(name = "second_photo")
    private String vehicle_second_photo_url;

    @Column(name = "third_photo")
    private String vehicle_third_photo_url;


}
