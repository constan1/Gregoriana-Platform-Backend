package com.Document.Customer.Service.DocumentsService.Service.Implementation;

import com.Document.Customer.Service.DocumentsService.Model.Documents.DriversLicense;
import com.Document.Customer.Service.DocumentsService.Model.Documents.OwnershipPaper;
import com.Document.Customer.Service.DocumentsService.Repository.DriversLicenseRepository;
import com.Document.Customer.Service.DocumentsService.Repository.OwnershipRepository;
import com.Document.Customer.Service.DocumentsService.Service.Services.DocumentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DocumentsImpl implements DocumentsService {

    private final DriversLicenseRepository driversLicenseRepository;

    private final OwnershipRepository ownershipRepository;

    @Override
    public void saveDriversLicense(DriversLicense driversLicense) {


        driversLicenseRepository.save(driversLicense);
    }

    @Override
    public void saveOwnershipPaper(OwnershipPaper ownershipPaper) {

        ownershipRepository.save(ownershipPaper);
    }
}
