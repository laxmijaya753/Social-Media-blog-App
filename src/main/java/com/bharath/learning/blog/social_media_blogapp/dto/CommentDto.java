package com.bharath.learning.blog.social_media_blogapp.dto;

import lombok.Data;

@Data
public class CommentDto {
    private Long id;
    private String name;
    private  String email;
    private  String body;
}
