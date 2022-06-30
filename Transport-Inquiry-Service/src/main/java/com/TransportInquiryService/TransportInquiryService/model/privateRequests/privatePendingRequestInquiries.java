package com.TransportInquiryService.TransportInquiryService.model.privateRequests;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Similar to public but private inquiries are from a supplier directly. Probably from a supplier that aggreed with
 * the driver on recurring orders.
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class privatePendingRequestInquiries {

    private String email;
    private String companyName;
    private String profileImage;
    private String trackingNumber;

}
