package com.FeedbackRatingService.Feedback.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

import javax.persistence.*;
import java.util.List;

@Entity(name="Feedback_Transport_Listing")
@Table(name="Feedback_Transport_Listing")
@OptimisticLocking(type = OptimisticLockType.DIRTY)
@DynamicUpdate
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class publicTransportListing {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "transporters_profile_pic_url")
    private String profile_pic_url;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name ="comment_id")
    private List<feedback> feedback;



}
