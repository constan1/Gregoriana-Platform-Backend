package com.RequestService.Request.Service.Repository;

import com.RequestService.Request.Service.Model.Consumers.AddOn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface AddOnRepository extends JpaRepository<AddOn,Long> {

    @Modifying
    @Transactional
    @Query("delete from AddOn d where d.id =:id")
    void deleteAddOn(@Param("id") Long id);
}
