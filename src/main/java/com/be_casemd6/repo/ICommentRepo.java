package com.be_casemd6.repo;

import com.be_casemd6.model.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ICommentRepo extends PagingAndSortingRepository<Comment,Integer> {
    List<Comment> findAllByProviderId(Integer id);
}
