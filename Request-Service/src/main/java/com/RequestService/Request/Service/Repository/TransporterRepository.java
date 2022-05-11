package com.RequestService.Request.Service.Repository;

import com.RequestService.Request.Service.Model.Transporters.PublicRequests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransporterRepository extends JpaRepository<PublicRequests,Long> {
}
