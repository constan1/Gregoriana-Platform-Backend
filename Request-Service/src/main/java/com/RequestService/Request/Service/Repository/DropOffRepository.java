package com.RequestService.Request.Service.Repository;

import com.RequestService.Request.Service.Model.Consumers.DropOffs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface DropOffRepository extends JpaRepository<DropOffs,Long> {

    @Modifying
    @Transactional
    @Query("delete from DropOffs d where d.id =:id")
    void deleteOffs(@Param("id") Long id);
}


