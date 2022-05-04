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

    @Query("select t from Transporter_Client t where t.auth_id=:authID")
    TransporterClient getTransporter(@Param("authID") String authID);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Transporter_Client t set t.photo_url =:photoUrl where t.auth_id =:authID")
    void updatePhotoUrl(@Param("photoUrl") String photoUrl, @Param("authID") String authId);


    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Transporter_Client t set t.verified =:verified where t.auth_id =:authID")
    void updateVerified(@Param("verified") Boolean verified, @Param("authID") String authId);

    @Modifying
    @Transactional
    @Query("update Transporter_Client t set t.phone =:phone where t.auth_id =:authID")
    void updatePhone(@Param("phone") Long phone, @Param("authID") String authID);


    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Address_  a set a.City =:City, a.country =:Country, a.postal_code =:Postal_Code," +
            " a.province =:Province, a.street_address =:Street_Address where a.id =:authID")
    void updateAddress(@Param("Country")String country, @Param("Street_Address")String street_address,
                       @Param("City") String city,
    @Param("Province")String province, @Param("Postal_Code") String postal_Code, @Param("authID") String authID);


    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Vehicle_ v set v.type =:type, v.make =:make, v.year =:year, v.condition =:condition, " +
            "v.description =:description, v.capacity =:capacity, v.load =:load, v.license_plate =:license_plate," +
            "v.ownership_paper =:ownership, v.first_photo_url =:first_url," +
            "v.second_photo_url =:second_url, v.third_photo_url =:third_url where  v.id =:authID")
    void updateVehicle(@Param("type") String type, @Param("make") String make, @Param("year") Integer year,
                       @Param("condition") Integer condition,  @Param("description") String description,
                       @Param("capacity") Integer capacity, @Param("load") String load,
                       @Param("license_plate") String license_plate, @Param("ownership") String ownership,
                       @Param("first_url") String first_url, @Param("second_url") String second_url,
                       @Param("third_url") String third_url, @Param("authID") String authID);






}
