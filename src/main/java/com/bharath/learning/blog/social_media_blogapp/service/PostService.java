package com.bharath.learning.blog.social_media_blogapp.service;

import com.bharath.learning.blog.social_media_blogapp.dto.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    List<PostDto> getAllPosts();
PostDto getPostById(Long id);

    PostDto updatePost(PostDto postDto, Long id);

    void deleteById(Long id);
}

