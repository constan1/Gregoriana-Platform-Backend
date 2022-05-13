package com.RequestService.Request.Service.Repository;

import com.RequestService.Request.Service.Model.Consumers.ConsumersInquiries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ConsumerInquiryRepository extends JpaRepository<ConsumersInquiries,Long> {

    @Query("select c from Consumers_Inquiries c where c.trackingNumber =:trackingNumber")
    List<ConsumersInquiries> getAllInquiriesForTrackingNumber(@Param("trackingNumber") String trackingNumber);

    @Modifying
    @Transactional
    @Query("delete from Consumers_Inquiries d where d.trackingNumber =:trackingNumber")
    void deleteConsumerInquiryByTrNum(@Param("trackingNumber") String trackingNum);

}
