package com.GregorianaUserService.User.Service.Service.Services;

import com.GregorianaUserService.User.Service.Model.Clients.TransporterClient;


public interface TransporterService {

    TransporterClient getTransporter(String authID);

    void Save_TransporterClient(TransporterClient transporterClient);

    void updatePhotoUrl( String photoUrl,String authId);


    void updateVerified( Boolean verified, String authId);

    void updatePhone(Long phone,String authID);

    void updateAddress(String country, String street_address,  String city,
                       String province, String postal_Code, String authID);


    void updateVehicle( String type,String make,  Integer year, Integer condition,  String description,
                        Integer capacity, String load, String license_plate, String ownership,
                      String first_url,  String second_url, String third_url, String authID);


}