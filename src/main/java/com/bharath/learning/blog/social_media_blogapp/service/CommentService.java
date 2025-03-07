package com.bharath.learning.blog.social_media_blogapp.service;

import com.bharath.learning.blog.social_media_blogapp.dto.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto createComment(long postId, CommentDto commentDto);
    List<CommentDto> getAllCommentsyPostId(long postId);
}
