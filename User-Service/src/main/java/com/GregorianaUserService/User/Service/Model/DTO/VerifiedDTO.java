package com.GregorianaUserService.User.Service.Model.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VerifiedDTO {

    private String authID;
    private Long id;
    private Boolean verified;
}
