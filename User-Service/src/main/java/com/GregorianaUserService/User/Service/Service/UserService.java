package com.GregorianaUserService.User.Service.Service;



import com.GregorianaUserService.User.Service.Model.Roles;
import com.GregorianaUserService.User.Service.Model.User;


public interface UserService {


    void Save_To_UserTable(User user_);

    void setUserRole(Roles role, String authID);



}
