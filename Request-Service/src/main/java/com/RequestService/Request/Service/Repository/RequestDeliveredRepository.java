package com.RequestService.Request.Service.Repository;

import com.RequestService.Request.Service.Model.Transporters.RequestHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestDeliveredRepository extends JpaRepository<RequestHistory,Long> {
}
