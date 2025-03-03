package com.bharath.learning.blog.social_media_blogapp.repository;

import com.bharath.learning.blog.social_media_blogapp.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

}
