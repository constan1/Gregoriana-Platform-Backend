package com.RequestService.Request.Service.Service.Implementation;

import com.RequestService.Request.Service.Model.Consumers.privateRequest.AddOn;
import com.RequestService.Request.Service.Model.Consumers.privateRequest.DropOffs;
import com.RequestService.Request.Service.Model.Consumers.privateRequest.Stop;
import com.RequestService.Request.Service.Model.Consumers.privateRequest.TransportRequests;
import com.RequestService.Request.Service.Model.Transporters.Vehicle;
import com.RequestService.Request.Service.Repository.CustomerRepository;
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


    @Mock
    private  TransporterListingRepository transporterListingRepository;

    @Mock
    private ConsumerInquiryRepository consumerInquiryRepository;

    @Mock
    private TransportInquiriesRepository transportInquiriesRepository;

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
    @DisplayName("Returns all Transport Requests")
    void customerService_getRequestForMarket_requestsReturnedSuccessfully() {
        Mockito.when(customerRepository.getRequestForMarket("pending")).thenReturn(request_list.getTransportRequestForMarket("pending"));

        Assertions.assertEquals(2,customerRepository.getRequestForMarket("pending").size());
    }

    @Test
    void getAllTransportListings() {

        Mockito.when(transporterListingRepository.getAllTransportListing()).thenReturn(request_list.getTransporterListing());

        Assertions.assertEquals(2,transporterListingRepository.getAllTransportListing().size());
    }

    @Test
    void getTransportersPersonalListing() {

        Mockito.when(transporterListingRepository.getTransportersListing("test@hotmail.com"))
                .thenReturn(request_list.getPersonalTransportListing("test@hotmail.com"));

        Assertions.assertNotNull(transporterListingRepository.getTransportersListing("test@hotmail.com"));
    }

    @Test
    void deleteTransportListing() {


        Mockito.when(transporterListingRepository.getAllTransportListing())
                .thenReturn(request_list.deleteTransportListing(request_list.getPersonalTransportListing("test@hotmail.com")));


        transporterListingRepository.delete(request_list.getPersonalTransportListing("test@hotmail.com"));
        Mockito.verify(transporterListingRepository, Mockito.times(1)).delete(request_list.getPersonalTransportListing("test@hotmail.com"));


        Assertions.assertEquals(1,transporterListingRepository.getAllTransportListing().size());
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

        TransportRequests transportRequests_4= new TransportRequests(1L,"a3","test","1111",date,stop_test_1,"testDesiredTime","pending",addOn);


        //--------Add Request -------//


        Mockito.when( customerRepository.save(transportRequests_4)).thenReturn(request_list.saveRequests(transportRequests_4).get(3));

        Assertions.assertNotNull(customerRepository.save(transportRequests_4));

    }

    @Test
    void createTransportListing() {
        Vehicle vehicle_3 = new Vehicle(1L,"testType_2",2022,5,30,"heavy","testPlate_2","test_ownership_2","test_first_photo_2","test_second_photo_2","test_third_photo_2");

        TransportListing transportListing_1 = new TransportListing("test3@hotmail.com",4168546160L,vehicle_3,10,"testDesc");


        Mockito.when(transporterListingRepository.save(transportListing_1))
                .thenReturn(request_list.saveTransportListing(transportListing_1));

        Assertions.assertNotNull(transporterListingRepository.save(transportListing_1));

    }

    @Test
    void creatConsumerInquiry() {
        Timestamp ts_2 = new Timestamp(System.currentTimeMillis());
        Date date_consumer = new Date(ts_2.getTime());


        ConsumersInquiries consumersInquiries_5 = new ConsumersInquiries(3L,"1111",date_consumer,request_list.getPersonalTransportListing("test@hotmail.com"));

        Mockito.when(consumerInquiryRepository.save(consumersInquiries_5))
                .thenReturn(request_list.createConsumerInquiries(consumersInquiries_5));

        Assertions.assertNotNull(consumerInquiryRepository.save(consumersInquiries_5));

    }


    @Test
    void deleteConsumerInquiry(){

        Mockito.when(consumerInquiryRepository.getAllInquiriesForTrackingNumber("4321"))
                .thenReturn(request_list.deleteConsumerInquiriesByTrackingNumber("4321"));

        consumerInquiryRepository.deleteConsumerInquiryByTrNum("4321");

        Mockito.verify(consumerInquiryRepository,Mockito.times(1)).deleteConsumerInquiryByTrNum("4321");


        Assertions.assertEquals(2,consumerInquiryRepository.getAllInquiriesForTrackingNumber("4321").size());

    }


    @Test
    void updateRequestStatus(){


        Mockito.when(customerRepository.getTransportRequestByTrackingNumber("4321"))
                .thenReturn(request_list.updateTransportRequestStatus("4321","Active"));

        Assertions.assertEquals("Active",customerRepository.getTransportRequestByTrackingNumber("4321").getStatus());

    }

    @Test
    void transporterActiveInquiry() {
        TransportInquiries transportInquiries_0_0 = new TransportInquiries(1L,"test@hotmail.com","4321");

        Mockito.when(transportInquiriesRepository.save(transportInquiries_0_0))
                .thenReturn(request_list.createTransportInquiries(transportInquiries_0_0).get(1));

        Assertions.assertNotNull(transportInquiriesRepository.save(transportInquiries_0_0));


    }

    @Test
    void getAllInquiriesForTrackingNumber() {

        Mockito.when(consumerInquiryRepository.getAllInquiriesForTrackingNumber("4321"))
                .thenReturn(request_list.getConsumerInquiriesForTrackingNumber("4321"));

        Assertions.assertEquals(2,consumerInquiryRepository.getAllInquiriesForTrackingNumber("4321").size());
    }

    @Test
    void getAllTransportInquiries() {

        Mockito.when(transportInquiriesRepository.getAllTransportInquiries("test_2@hotmail.com"))
                .thenReturn(request_list.getTransportInquiriesForEmail("test_2@hotmail.com"));
        Assertions.assertEquals(1,transportInquiriesRepository.getAllTransportInquiries("test_2@hotmail.com").size());
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