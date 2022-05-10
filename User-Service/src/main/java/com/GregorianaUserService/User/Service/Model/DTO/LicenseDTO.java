package com.GregorianaUserService.User.Service.Model.DTO;


import com.GregorianaUserService.User.Service.Documents.License;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LicenseDTO {

    private String authID;
    private License drivers_license;
}
