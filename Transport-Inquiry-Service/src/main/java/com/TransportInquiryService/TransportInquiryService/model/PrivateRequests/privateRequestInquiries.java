package com.TransportInquiryService.TransportInquiryService.model.PrivateRequests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * This will be list of pending requests for the transporter. Trips has been created only once the status is "Active" ( Hypertrak api not called).
 */

@Entity(name="PrivatePendingRequestInquiries")
@Table(name = "PrivatePendingRequestInquiries")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class privateRequestInquiries {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String transporters_email;
    private Long suppliers_phoneNumber;
    private String supplier_companyName;
    private String suppliers_profileImage;
    private String request_trackingNumber;

    private Boolean private_Request_Inquiry_status;



}
