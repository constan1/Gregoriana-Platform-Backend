package com.GregorianaUserService.User.Service.Repository;

import com.GregorianaUserService.User.Service.Model.Clients.BusinessClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface BusinessClientRepository extends JpaRepository<BusinessClient, String> {


    @Query("select b from Business_Client b where b.authID =:authID")
    BusinessClient selectBusinessClient(@Param("authID") String authID);


    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Business_Client b set b.profile_photo_url =:photoUrl where b.authID =:authID")
    void updatePhotoUrl( @Param("photoUrl") String photoUrl, @Param("authID") String authId);


    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Business_Client b set b.phone_num =:phone where b.authID =:authID")
    void updatePhone(@Param("phone") Long phone, @Param("authID") String authID);

}
