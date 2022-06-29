package com.GregorianaUserService.User.Service.Repository;


import com.GregorianaUserService.User.Service.Model.Clients.RetailClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface RetailClientRepository extends JpaRepository<RetailClient,String> {

    @Query("select r from Retail_Client r where r.authID =:authID")
    RetailClient selectRetailClient(@Param("authID") String authID);


    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Retail_Client r set r.profile_photo_url =:photoUrl where  r.authID =:authID")
    void updatePhotoUrl(@Param("photoUrl") String photoUrl,
                        @Param("authID") String authId);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Retail_Client r set r.phone =:phone where r.authID =:authID")
    void updatePhone(@Param("phone") Long phone,
                     @Param("authID") String authID);


}
