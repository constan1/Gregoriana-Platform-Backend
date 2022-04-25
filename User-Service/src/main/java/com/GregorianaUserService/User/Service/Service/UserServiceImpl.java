package com.GregorianaUserService.User.Service.Service;

import com.GregorianaUserService.User.Service.Dto.RoleDto;
import com.GregorianaUserService.User.Service.Model.Roles;
import com.GregorianaUserService.User.Service.Model.User;
import com.GregorianaUserService.User.Service.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{




    private final UserRepository userRepository;

    @Override
    public void Save_To_UserTable(User user_) {

        Date date = new Date(System.currentTimeMillis());
        user_.setDate_joined(date);

        userRepository.save(user_);

    }

    @Override
    public void setUserRole(Roles role, String authID) {
        userRepository.setUserRole(role,authID);
    }


}
