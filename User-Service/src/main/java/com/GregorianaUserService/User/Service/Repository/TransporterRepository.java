package com.GregorianaUserService.User.Service.Repository;

import com.GregorianaUserService.User.Service.Model.Clients.TransporterClient;
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

    @Query("select t from Transporter_Client t where t.user.auth_id =:authID")
    TransporterClient getTransporter(@Param("authID") String authID);


    @Modifying
    @Transactional
    @Query("Update Transporter_Client t set t.total_vehicles =:totalVehicles where t.user.auth_id =:authID")
    void updateVehicles(@Param("totalVehicles") List<Vehicle> Vehicles, @Param("authID") String authID);
}
