package com.Document.Customer.Service.DocumentsService.Repository;

import com.Document.Customer.Service.DocumentsService.Model.Documents.OwnershipPaper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnershipRepository extends JpaRepository<OwnershipPaper, Long> {

}
