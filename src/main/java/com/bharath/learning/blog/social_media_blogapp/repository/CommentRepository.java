package com.bharath.learning.blog.social_media_blogapp.repository;

import com.bharath.learning.blog.social_media_blogapp.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByPostId(long postId);
}
