package com.GregorianaUserService.User.Service.Model.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhoneDTO {


    private String authID;
    private Long id;
    private Long phone;

}
