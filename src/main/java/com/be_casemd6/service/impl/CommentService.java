package com.be_casemd6.service.impl;

import com.be_casemd6.model.Comment;
import com.be_casemd6.repo.ICommentRepo;
import com.be_casemd6.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

@Service
public class CommentService implements ICommentService {
    @Autowired
    ICommentRepo iCommentRepo;
    @Override
    public Comment save(Comment comment) {
        return iCommentRepo.save(comment);
    }

    @Override
    public List<Comment> getAllCommentByIdProvider(Integer id) {
        return iCommentRepo.findAllByProviderId(id);
    }

    @Override
    public Double averageScore(int id) {
        return iCommentRepo.averageScore(id);
    }

    @Override
    public Double countComment(int id) {
        return iCommentRepo.countComment(id);
    }
}
