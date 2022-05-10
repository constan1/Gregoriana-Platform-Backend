package com.GregorianaUserService.User.Service.Repository;


import com.GregorianaUserService.User.Service.Model.Clients.TransporterClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;



@Repository
public interface TransporterRepository extends JpaRepository<TransporterClient,String> {

    @Query("select t from Transporter_Client t where t.authID =:authID")
    TransporterClient getTransporter(@Param("authID") String authID);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Transporter_Client t set t.photo_url =:photoUrl where t.authID =:authID")
    void updatePhotoUrl(@Param("photoUrl") String photoUrl,
                        @Param("authID") String authId);


    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Transporter_Client t set t.verified =:verified where  t.authID =:authID")
    void updateVerified(@Param("verified") Boolean verified,
                        @Param("authID") String authId);

    @Modifying
    @Transactional
    @Query("update Transporter_Client t set t.phone =:phone where  t.authID =:authID")
    void updatePhone(@Param("phone") Long phone,
                     @Param("authID") String authID);


    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Transporter_Address  a set a.City =:City, a.country =:Country, a.postal_code =:Postal_Code," +
            " a.province =:Province, a.street_address =:Street_Address where a.authID =:authID")
    void updateAddress(@Param("Country")String country, @Param("Street_Address")String street_address,
                       @Param("City") String city,@Param("Province")String province, @Param("Postal_Code") String postal_Code,
                      @Param("authID") String authID);



    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Documents_Drivers_License d set d.drivers_photo_url =:driversPhoto where d.authID =:authID")
    void updateLicensePhoto(@Param("driversPhoto") String photo_url,@Param("authID") String authID);








}
