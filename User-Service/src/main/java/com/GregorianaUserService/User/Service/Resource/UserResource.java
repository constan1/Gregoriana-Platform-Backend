package com.GregorianaUserService.User.Service.Resource;


import com.GregorianaUserService.User.Service.Dto.RoleDto;
import com.GregorianaUserService.User.Service.Model.Roles;
import com.GregorianaUserService.User.Service.Model.User;
import com.GregorianaUserService.User.Service.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserResource {




    private final UserService userService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user_){
        userService.Save_To_UserTable(user_);
    }


    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update_set_userRole(@RequestBody User user_){


        userService.setUserRole(user_.getRole_(),user_.getAuth_id());

    }


}
