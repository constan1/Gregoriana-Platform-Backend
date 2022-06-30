package com.TransportInquiryService.TransportInquiryService.model.activeRequests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This will be list of active requests for the transporter. Trips have been created ( Hypertrak api called).
 */


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class activeRequestInquiries {

    private String email;
    private Long phoneNumber;
    private String companyName;
    private String profileImage;
    private String trackingNumber;

}
