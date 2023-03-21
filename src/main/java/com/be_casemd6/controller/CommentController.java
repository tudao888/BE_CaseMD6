package com.be_casemd6.controller;

import com.be_casemd6.model.Comment;
import com.be_casemd6.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.List;

@CrossOrigin("*")
@RestController
public class CommentController {
    @Autowired
    ICommentService iCommentService;

    @PostMapping("/m/comment")
    public ResponseEntity<Comment> saveComment(@RequestBody Comment comment) {
        return new ResponseEntity<>(iCommentService.save(comment), HttpStatus.OK);
    }

    @GetMapping("/m/comment/{id}")
    public ResponseEntity<List<Comment>> getAllCommentByProviderId(@PathVariable int id) {
        return new ResponseEntity<>(iCommentService.getAllCommentByIdProvider(id), HttpStatus.OK);
    }

    @GetMapping("/m/score/{id}")
    public ResponseEntity<Double> averagerScore(@PathVariable int id) {
        double score = Math.ceil((iCommentService.averageScore(id) *100)) / 100;
        return new ResponseEntity<>(score, HttpStatus.OK);
    }
    @GetMapping("/m/stars/{id}")
    public ResponseEntity<Double> starScore(@PathVariable int id) {
        double score = Math.ceil((iCommentService.averageScore(id)));
        return new ResponseEntity<>(score, HttpStatus.OK);
    }

    @GetMapping("/m/countComment/{id}")
    public ResponseEntity<Double> countComment(@PathVariable int id) {
        return new ResponseEntity<>(iCommentService.countComment(id), HttpStatus.OK);
    }

}
