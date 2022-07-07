package com.requestsservice.requestsservice.service.implementation;





import com.requestsservice.requestsservice.Model.AddOn;
import com.requestsservice.requestsservice.Model.DropOffs;
import com.requestsservice.requestsservice.Model.Stop;
import com.requestsservice.requestsservice.Model.TransportRequests;

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


    private static TransportRequests transportRequests;

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

        TransportRequests  transportRequests_1= new TransportRequests(1l,"a1","test","4321",date,stop_test_1,"testDesiredTime","pending",addOn,"DEMO","url");
        TransportRequests  transportRequests_2= new TransportRequests(2l,"a2","test","555",date,stop_test_2,"testDesiredTime","active",addOn,"DEMO","url");
        TransportRequests  transportRequests_3= new TransportRequests(3l,"a1","test","1234",date,stop_test_2,"testDesiredTime","pending",addOn,"DEMO","url");

        transportRequestslist.add(transportRequests_1);
        transportRequestslist.add(transportRequests_2);
        transportRequestslist.add(transportRequests_3);



    }

    public List<com.requestsservice.requestsservice.Model.TransportRequests> getTransportPrivateRequestsList_(String auth_id){

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





    public List<TransportRequests> saveRequests(TransportRequests transportRequests_main){

        List<TransportRequests> transportRequests_1 = new ArrayList<>(transportRequestslist);
        transportRequests_1.add(transportRequests_main);

        return transportRequests_1;

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


    public List<TransportRequests> deleteTransportRequest(TransportRequests transportRequests_main){

        List<TransportRequests> transportRequestsList = new ArrayList<>(transportRequestslist);

        transportRequestsList.removeIf(transportRequests2 -> transportRequests2 == transportRequests_main);

        return transportRequestsList;
    }





}
