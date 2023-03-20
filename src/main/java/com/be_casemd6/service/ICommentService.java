package com.be_casemd6.service;

import com.be_casemd6.model.Comment;

import java.util.List;

public interface ICommentService {
    Comment save(Comment comment);
    List<Comment> getAllCommentByIdProvider(Integer id);
}
