package com.be_casemd6.repo;

import com.be_casemd6.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IImageRepo extends JpaRepository<Image, Integer> {
    @Query(nativeQuery = true,value = "select * from casemd6.image where image.account_id=:accountId and image.status_img=1")
    List<Image> findByAccount_IdAAndStatusImg1(@Param("accountId") Integer accountId);
}
