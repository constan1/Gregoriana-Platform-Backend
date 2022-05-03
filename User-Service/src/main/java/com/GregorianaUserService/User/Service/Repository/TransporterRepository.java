package com.GregorianaUserService.User.Service.Repository;

import com.GregorianaUserService.User.Service.Model.Address;
import com.GregorianaUserService.User.Service.Model.Clients.TransporterClient;
import com.GregorianaUserService.User.Service.Model.User;
import com.GregorianaUserService.User.Service.Model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;


@Repository
public interface TransporterRepository extends JpaRepository<TransporterClient,Long> {

    @Query("select t from Transporter_Client t where t.auth_id=:authID")
    TransporterClient getTransporter(@Param("authID") String authID);



    @Modifying
    @Transactional
    @Query("update Transporter_Client t set t.photo_url =:photoUrl where t.auth_id =:authID")
    void updatePhotoUrl(@Param("photoUrl") String photoUrl, @Param("authID") String authId);


    @Modifying
    @Transactional
    @Query("update Transporter_Client t set t.verified =:verified where t.auth_id =:authID")
    void updateVerified(@Param("verified") Boolean verified, @Param("authID") String authId);

    @Modifying
    @Transactional
    @Query("update Transporter_Client t set t.phone =:phone where t.auth_id =:authID")
    void updatePhone(@Param("phone") Long phone, @Param("authID") String authID);



}
