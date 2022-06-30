package com.TransportInquiryService.TransportInquiryService.model.pendingRequests;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Pending list of requests. The supplier or customer has not paid yet.
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class publicPendingRequestInquiries {


    private String email;
    private String trackingNumber;

}
