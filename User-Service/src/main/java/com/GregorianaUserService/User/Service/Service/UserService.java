package com.GregorianaUserService.User.Service.Service;


import com.GregorianaUserService.User.Service.Dto.RoleDto;
import com.GregorianaUserService.User.Service.Model.Roles;
import com.GregorianaUserService.User.Service.Model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {


    void Save_To_UserTable(User user_);

    void setUserRole(Roles role, String authID);



}
