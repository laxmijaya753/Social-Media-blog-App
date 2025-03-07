package com.bharath.learning.blog.social_media_blogapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comments;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="posts")
public class Post {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

private Long id;
    @Column(name="title")
private  String title;
    @Column(name="description")
private String description;
    @Column(name="content")
private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    //One to Mant mapping b/w post and comment
    @OneToMany(mappedBy ="post",cascade =CascadeType.ALL,orphanRemoval = true)
    private Set<Comment> comments=new HashSet<>();
}
