package com.GregorianaUserService.User.Service.Repository;


import com.GregorianaUserService.User.Service.Model.Roles;
import com.GregorianaUserService.User.Service.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


//    @Query(value = "SELECT 'User.date_joined' FROM User WHERE 'User.auth_id' =?1 ", nativeQuery = true)
//    String Find_By_Id_And_Email(String auth_id);


    @Modifying
    @Transactional
    @Query("Update User u set u.role =:userRole where u.auth_id =:authID")
    void setUserRole(@Param("userRole")Roles role, @Param("authID") String authID);
}
