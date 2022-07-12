package com.requestsservice.requestsservice.service.implementation;




import com.requestsservice.requestsservice.Model.AddOn;
import com.requestsservice.requestsservice.Model.DropOffs;
import com.requestsservice.requestsservice.Model.Stop;
import com.requestsservice.requestsservice.Model.TransportRequests;
import com.requestsservice.requestsservice.Repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Test implementation of the services with dummy data
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CustomerServiceImplTest {



    @Mock
    private CustomerRepository customerRepository;

    static testData request_list =  new testData();


    @BeforeAll
    static void setUp(){
        request_list.setList();
    }

    @Test
    @DisplayName("Should return the request for the customer")
    void customerService_getRequestForClient_requestReturnedSuccessfully() {
        Mockito.when(customerRepository.getRequestForClient("a1")).thenReturn(request_list.getTransportPrivateRequestsList_("a1"));

        Assertions.assertEquals(2,customerRepository.getRequestForClient("a1").size());
    }

    @Test
    @DisplayName("Returns Transport Request by tracking number")
    void customerService_getTransportRequestByTrackingNumber_requestReturnedSuccessfully(){

        Mockito.when(customerRepository.getTransportRequestByTrackingNumber("1234"))
                .thenReturn(request_list.getTransportRequestFromTrackingNumber("1234"));
        Assertions.assertEquals("1234",customerRepository.getTransportRequestByTrackingNumber("1234").getTrackingNumber());

    }




    @Test
    void createRequest() {


        //--------Add Request -------//

        Timestamp ts = new Timestamp(System.currentTimeMillis());
        Date date = new Date(ts.getTime());

        List<DropOffs> list_dropOffs_1 = new ArrayList<>();

        DropOffs dropOffs_1 = new DropOffs(1L,"droptestAddress",1.00f,1.00f);
        DropOffs dropOffs_1_1 = new DropOffs(2L,"droptestAddress",1.00f,1.00f);

        list_dropOffs_1.add(dropOffs_1);
        list_dropOffs_1.add(dropOffs_1_1);

        AddOn addOn = new AddOn(1L,0,false);
        Stop stop_test_1 = new Stop(1L,"testStopAddress_1",2.00f,2.00f,"testDesc","testPhoto",list_dropOffs_1);

        TransportRequests transportRequests_4= new TransportRequests(1L,"a3","test","1111",date,stop_test_1,"testDesiredTime","pending",addOn,"DEMO");


        //--------Add Request -------//


        Mockito.when( customerRepository.save(transportRequests_4)).thenReturn(request_list.saveRequests(transportRequests_4).get(3));

        Assertions.assertNotNull(customerRepository.save(transportRequests_4));

    }







    @Test
    void updateRequestStatus(){


        Mockito.when(customerRepository.getTransportRequestByTrackingNumber("4321"))
                .thenReturn(request_list.updateTransportRequestStatus("4321","Active"));

        Assertions.assertEquals("Active",customerRepository.getTransportRequestByTrackingNumber("4321").getStatus());

    }






    @Test
    void deleteTransportRequest() {

        Mockito.when(customerRepository.findAll())
                .thenReturn(request_list.deleteTransportRequest(request_list.getTransportRequestFromTrackingNumber("4321")));

        customerRepository.delete(request_list.getTransportRequestFromTrackingNumber("4321"));

        Mockito.verify(customerRepository,Mockito.times(1)).delete(request_list.getTransportRequestFromTrackingNumber("4321"));


        Assertions.assertEquals(2,customerRepository.findAll().size());



    }
}