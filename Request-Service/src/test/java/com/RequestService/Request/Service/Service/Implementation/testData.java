package com.RequestService.Request.Service.Service.Implementation;

import com.RequestService.Request.Service.Model.Consumers.ConsumersInquiries;
import com.RequestService.Request.Service.Model.Consumers.privateRequest.AddOn;
import com.RequestService.Request.Service.Model.Consumers.privateRequest.DropOffs;
import com.RequestService.Request.Service.Model.Consumers.privateRequest.Stop;
import com.RequestService.Request.Service.Model.Consumers.privateRequest.TransportRequests;
import com.RequestService.Request.Service.Model.Transporters.TransportInquiries;
import com.RequestService.Request.Service.Model.Transporters.TransportListing;
import com.RequestService.Request.Service.Model.Transporters.Vehicle;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * This is a test data class - Stores data in memory. Data access layer ( db connection ) will be tested seperately.
 */
public class testData {


    private static final List<TransportRequests> transportRequestslist = new ArrayList<TransportRequests>();

    private static final List<TransportListing> transportListingList = new ArrayList<>();

    private static final List<ConsumersInquiries> consumerInquiriesList = new ArrayList<>();

    private static final List<TransportInquiries> transportInquiriesList = new ArrayList<>();

    private static TransportRequests transportRequests;

    private static TransportListing transportListing;

    private static ConsumersInquiries consumersInquiries;

    private static TransportInquiries transportInquiries;

    public void setList(){


        //----------Transport Requests Data----------//

        Timestamp ts = new Timestamp(System.currentTimeMillis());
        Date date = new Date(ts.getTime());

        List<DropOffs> list_dropOffs_1 = new ArrayList<>();
        List<DropOffs> list_dropOffs_2 = new ArrayList<>();

        DropOffs dropOffs_1 = new DropOffs(1L,"droptestAddress",1.00f,1.00f);
        DropOffs dropOffs_1_1 = new DropOffs(2L,"droptestAddress",1.00f,1.00f);
        DropOffs dropOffs_2 = new DropOffs(1L,"droptestAddress2",1.10f,1.10f);

        list_dropOffs_1.add(dropOffs_1);
        list_dropOffs_2.add(dropOffs_2);
        list_dropOffs_1.add(dropOffs_1_1);

        AddOn addOn = new AddOn(1L,0,false);
        Stop stop_test_1 = new Stop(1L,"testStopAddress_1",2.00f,2.00f,"testDesc","testPhoto",list_dropOffs_1);
        Stop stop_test_2 = new Stop(1L,"testStopAddress_2",2.00f,2.00f,"testDesc","testPhoto",list_dropOffs_2);

        TransportRequests  transportRequests_1= new TransportRequests(1l,"a1","test","4321",date,stop_test_1,"testDesiredTime","pending",addOn);
        TransportRequests  transportRequests_2= new TransportRequests(2l,"a2","test","555",date,stop_test_2,"testDesiredTime","active",addOn);
        TransportRequests  transportRequests_3= new TransportRequests(3l,"a1","test","1234",date,stop_test_2,"testDesiredTime","pending",addOn);

        transportRequestslist.add(transportRequests_1);
        transportRequestslist.add(transportRequests_2);
        transportRequestslist.add(transportRequests_3);


        //----------Transport Listing Data----------//

        Vehicle vehicle = new Vehicle(1L,"testType",2022,5,30,"heavy","testPlate","test_ownership","test_first_photo","test_second_photo","test_third_photo");
        Vehicle vehicle_2 = new Vehicle(1L,"testType_2",2022,5,30,"heavy","testPlate_2","test_ownership_2","test_first_photo_2","test_second_photo_2","test_third_photo_2");

        TransportListing transportListing_1 = new TransportListing("test@hotmail.com",4168546160L,vehicle,10,"testDesc");

        TransportListing transportListing_2 = new TransportListing("test_2@hotmail.com",4168546160L,vehicle_2,15,"testDesc2");


        transportListingList.add(transportListing_1);
        transportListingList.add(transportListing_2);

        //----------Consumer Inquiry Data----------//

        Timestamp ts_2 = new Timestamp(System.currentTimeMillis());
        Date date_consumer = new Date(ts.getTime());
        Date date_consumer_2 = new Date(ts.getTime() + 1000);
        Date date_consumer_3 = new Date(ts.getTime() + 2000);
        Date date_consumer_4 = new Date(ts.getTime() + 3000);

        ConsumersInquiries consumersInquiries_0_0 = new ConsumersInquiries(1L,"4321",date_consumer,transportListing_1);

        ConsumersInquiries consumersInquiries_1_1 = new ConsumersInquiries(2L,"4321",date_consumer_2,transportListing_2);

        ConsumersInquiries consumersInquiries_0_2 = new ConsumersInquiries(2L,"1234",date_consumer_3,transportListing_1);

        ConsumersInquiries consumersInquiries_1_2 = new ConsumersInquiries(2L,"555",date_consumer_4,transportListing_2);

        consumerInquiriesList.add(consumersInquiries_0_0);
        consumerInquiriesList.add(consumersInquiries_1_1);
        consumerInquiriesList.add(consumersInquiries_0_2);
        consumerInquiriesList.add(consumersInquiries_1_2);


        TransportInquiries transportInquiries_0_0 = new TransportInquiries(1L,"test_2@hotmail.com","4321");


        transportInquiriesList.add(transportInquiries_0_0);
    }

    public List<TransportRequests> getTransportPrivateRequestsList_(String auth_id){

        List<TransportRequests> transportRequestsPrivateList = new ArrayList<>(transportRequestslist);

        transportRequestsPrivateList.removeIf(transportRequests -> !Objects.equals(transportRequests.getAuthID(), auth_id));

        return transportRequestsPrivateList;
    }

    public TransportRequests getTransportRequestFromTrackingNumber(String trackingNumber){
        for(TransportRequests transportRequests_ : transportRequestslist){
            if(Objects.equals(transportRequests_.getTrackingNumber(),trackingNumber)){
                transportRequests = transportRequests_;
            }
        }
        return transportRequests;
    }

    public List<TransportRequests> getTransportRequestForMarket(String status){

        List<TransportRequests> transportRequestsPublicList = new ArrayList<>(transportRequestslist);

        transportRequestsPublicList.removeIf(transportRequests_ -> !Objects.equals(transportRequests_.getStatus(), status));

        return transportRequestsPublicList;
    }

    public List<TransportListing> getTransporterListing(){
        return transportListingList;
    }

    public List<TransportListing> deleteTransportListing(TransportListing transportListing){

        List<TransportListing> transportListingList_ = new ArrayList<>(transportListingList);


        transportListingList_.removeIf(transportListing1 -> transportListing1 == transportListing);

        return transportListingList_;
    }

    public TransportListing getPersonalTransportListing(String email){
        for(TransportListing transportListing_ : transportListingList){
            if(Objects.equals(transportListing_.getEmail(), email)){
                transportListing = transportListing_;
            }

        }
        return transportListing;
    }

    public List<TransportRequests> saveRequests(TransportRequests transportRequests_main){

        List<TransportRequests> transportRequests_1 = new ArrayList<>(transportRequestslist);
        transportRequests_1.add(transportRequests_main);

        return transportRequests_1;

    }


    public TransportListing saveTransportListing(TransportListing transportListing_main){

        List<TransportListing> transportListingList_ = new ArrayList<>(transportListingList);

        transportListingList_.add(transportListing_main);

        for(TransportListing transportListing_ : transportListingList_){
            if(Objects.equals(transportListing_.getEmail(), transportListing_main.getEmail())){
                transportListing = transportListing_;
            }

        }

        return transportListing;

    }

    public ConsumersInquiries createConsumerInquiries(ConsumersInquiries consumersInquiries_main){

        List<ConsumersInquiries> consumerInquiriesList_ = new ArrayList<>(consumerInquiriesList);
        consumerInquiriesList_.add(consumersInquiries_main);

        for(ConsumersInquiries consumersInquiries1 : consumerInquiriesList_){
            if(Objects.equals(consumersInquiries1.getTrackingNumber(), consumersInquiries_main.getTrackingNumber())){
                consumersInquiries = consumersInquiries1;
            }
        }

        return consumersInquiries;
    }

    public List<TransportInquiries> createTransportInquiries(TransportInquiries transportInquiries_main){


        List<TransportInquiries> transportInquiries_ = new ArrayList<>(transportInquiriesList) ;
        transportInquiries_.add(transportInquiries_main);
        return transportInquiries_;
    }

    public List<ConsumersInquiries> getConsumerInquiriesForTrackingNumber(String tracking_num){

        List<ConsumersInquiries> consumerInquiriesList_ = new ArrayList<>(consumerInquiriesList);

        consumerInquiriesList_.removeIf(consumersInquiries_ -> !Objects.equals(consumersInquiries_.getTrackingNumber(), tracking_num));
        return consumerInquiriesList_;
    }

    public List<ConsumersInquiries> deleteConsumerInquiriesByTrackingNumber(String tracking_num){

        List<ConsumersInquiries> consumerInquiriesList_ = new ArrayList<>(consumerInquiriesList);

        consumerInquiriesList_.removeIf(consumersInquiries1 -> Objects.equals(consumersInquiries1.getTrackingNumber(), tracking_num));

        return consumerInquiriesList_;

    }

    public TransportRequests updateTransportRequestStatus(String trackingNumber, String status){

        List<TransportRequests> transportRequestsList_ = new ArrayList<>(transportRequestslist);

        for(TransportRequests transportRequests_ : transportRequestsList_){
            if(Objects.equals(transportRequests_.getTrackingNumber(), trackingNumber)){
               transportRequests_.setStatus(status);
               transportRequests = transportRequests_;
            }
        }

        return transportRequests;

    }

    public List<TransportInquiries> getTransportInquiriesForEmail(String email){

        List<TransportInquiries> transportInquiries_main = new ArrayList<>(transportInquiriesList);
        transportInquiries_main.removeIf(transportInquiries -> !Objects.equals(transportInquiries.getEmail(), email));

        return transportInquiries_main;
    }

    public List<TransportRequests> deleteTransportRequest(TransportRequests transportRequests_main){

        List<TransportRequests> transportRequestsList = new ArrayList<>(transportRequestslist);

        transportRequestsList.removeIf(transportRequests2 -> transportRequests2 == transportRequests_main);

        return transportRequestsList;
    }





}
