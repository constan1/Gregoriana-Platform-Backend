package com.GregorianaUserService.User.Service.Repository;

import com.GregorianaUserService.User.Service.Model.Clients.BusinessClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface BusinessClientRepository extends JpaRepository<BusinessClient, String> {


    @Query("select b from Business_Client b where b.id =:authID")
    BusinessClient selectBusinessClient(@Param("authID") String authID);


    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Business_Client b set b.profile_photo_url =:photoUrl where b.id =:authID")
    void updatePhotoUrl(@Param("photoUrl") String photoUrl, @Param("authID") String authId);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Business_Client b set b.phone_num =:phone where b.id =:authID")
    void updatePhone(@Param("phone") Long phone, @Param("authID") String authID);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Address_  a set a.City =:City, a.country =:Country, a.postal_code =:Postal_Code," +
            " a.province =:Province, a.street_address =:Street_Address where a.id =:authID")
    void updateAddress(@Param("Country")String country, @Param("Street_Address")String street_address,
                       @Param("City") String city,
                       @Param("Province")String province, @Param("Postal_Code") String postal_Code, @Param("authID") String authID);
}
