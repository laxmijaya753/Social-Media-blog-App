package com.bharath.learning.blog.social_media_blogapp.service;

import com.bharath.learning.blog.social_media_blogapp.dto.PostDto;
import com.bharath.learning.blog.social_media_blogapp.pageLoad.PostResponse;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
   // List<PostDto> getAllPosts();
   PostResponse getAllPosts(int pageNo, int pageSize);
PostDto getPostById(Long id);

    PostDto updatePost(PostDto postDto, Long id);

    void deleteById(Long id);
}

