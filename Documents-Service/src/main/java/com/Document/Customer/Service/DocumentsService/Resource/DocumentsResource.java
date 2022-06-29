package com.Document.Customer.Service.DocumentsService.Resource;


import com.Document.Customer.Service.DocumentsService.Model.Documents.DriversLicense;
import com.Document.Customer.Service.DocumentsService.Model.Documents.OwnershipPaper;
import com.Document.Customer.Service.DocumentsService.Service.Services.DocumentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/documents")
@RequiredArgsConstructor
public class DocumentsResource {

    private final DocumentsService documentsService;


    @PostMapping("/driversLicense")
    @ResponseStatus(HttpStatus.CREATED)
    private void driversLicense(@RequestBody DriversLicense driversLicense) throws  Exception{
        documentsService.saveDriversLicense(driversLicense);
    }

    @PostMapping("/ownership")
    @ResponseStatus(HttpStatus.CREATED)
    private void ownership(@RequestBody OwnershipPaper ownershipPaper) throws Exception {
        documentsService.saveOwnershipPaper(ownershipPaper);
    }


}
