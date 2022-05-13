package com.RequestService.Request.Service.Repository;

import com.RequestService.Request.Service.Model.Transporters.PublicRequests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PublicRequestsRepository extends JpaRepository<PublicRequests,String> {

    @Modifying
    @Transactional
    @Query("delete from Public_Requests p where p.id =:id")
    void deletePublicRequest(@Param("id") Long id);

    @Query("select p from Public_Requests p where p.trackingNumber =:trackingNum")
    PublicRequests selectedPublicRequest(@Param("trackingNum") String trackingNumber);
}
