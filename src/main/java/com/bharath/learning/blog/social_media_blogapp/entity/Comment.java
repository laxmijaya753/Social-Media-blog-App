package com.bharath.learning.blog.social_media_blogapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String email;
    private String body;
//mapping b/w comment and posts
    @ManyToOne
    @JoinColumn(name="post_id",nullable = false)
    private Post post;


}
