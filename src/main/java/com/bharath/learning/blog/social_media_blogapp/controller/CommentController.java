package com.bharath.learning.blog.social_media_blogapp.controller;

import com.bharath.learning.blog.social_media_blogapp.dto.CommentDto;
import com.bharath.learning.blog.social_media_blogapp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vi")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable("postId")long postId, @RequestBody CommentDto commentDto){
      CommentDto savedCommentDto=commentService.createComment(postId,commentDto);
return new ResponseEntity<>(savedCommentDto, HttpStatus.CREATED);
    }
    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity<List<CommentDto>>fetchAllCommentsByPostId(@PathVariable("postId")Long postId){
     List<CommentDto> commentDtoList=commentService.getAllCommentsyPostId(postId);
     return new ResponseEntity<>(commentDtoList,HttpStatus.OK);
    }
}
