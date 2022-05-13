package com.RequestService.Request.Service.Repository;

import com.RequestService.Request.Service.Model.Consumers.Stop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface StopsRepository extends JpaRepository<Stop, Long> {

    @Modifying
    @Transactional
    @Query("delete from Stops d where d.id =:id")
    void deleteStops(@Param("id") Long id);
}

