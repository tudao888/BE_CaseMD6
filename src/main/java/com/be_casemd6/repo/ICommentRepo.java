package com.be_casemd6.repo;

import com.be_casemd6.model.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.text.DecimalFormat;
import java.util.List;

public interface ICommentRepo extends PagingAndSortingRepository<Comment,Integer> {
    List<Comment> findAllByProviderId(Integer id);

    @Query(nativeQuery = true,value = "SELECT avg(comment.rate) FROM comment WHERE comment.provider_id = :providerId ")
    Double averageScore(@Param("providerId") int providerId);

    @Query(nativeQuery = true,value = "SELECT count(comment.rate) FROM comment WHERE comment.provider_id = :providerId ")
    Double countComment(@Param("providerId") int providerId);



}
