package com.RequestService.Request.Service.Repository;

import com.RequestService.Request.Service.Model.Transporters.TransportInquiries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TransportInquiriesRepository extends JpaRepository<TransportInquiries,String> {

    @Query("select i from Transporters_Inquiries  i where i.email =:email_")
    List<TransportInquiries> getAllTransportInquiries(@Param("email_") String email);

    @Modifying
    @Transactional
    @Query("delete from Transporters_Inquiries d where d.referenceTrackingNumber =:trackingNum")
    void deleteTransportInquiriesFromTrackingNum(@Param("trackingNum")String trackingNumber);

    @Query("select i from Transporters_Inquiries i where i.referenceTrackingNumber =:trackingNumber")
    TransportInquiries getTrackingInquiry(@Param("trackingNumber")String trackingNumber);





}
