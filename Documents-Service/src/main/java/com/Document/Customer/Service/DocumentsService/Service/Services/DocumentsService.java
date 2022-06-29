package com.Document.Customer.Service.DocumentsService.Service.Services;

import com.Document.Customer.Service.DocumentsService.Model.Documents.DriversLicense;
import com.Document.Customer.Service.DocumentsService.Model.Documents.OwnershipPaper;

public interface DocumentsService {

    void saveDriversLicense(DriversLicense driversLicense);

    void saveOwnershipPaper(OwnershipPaper ownershipPaper);


}
