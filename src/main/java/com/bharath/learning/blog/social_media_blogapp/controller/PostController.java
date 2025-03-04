package com.bharath.learning.blog.social_media_blogapp.controller;

import com.bharath.learning.blog.social_media_blogapp.dto.PostDto;
import com.bharath.learning.blog.social_media_blogapp.pageLoad.PostResponse;
import com.bharath.learning.blog.social_media_blogapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        PostDto savedPostDto = postService.createPost(postDto);

        return new ResponseEntity(savedPostDto, HttpStatus.CREATED);
    }
//
//    @GetMapping
//    public List<PostDto> getAllPosts() {
//        return postService.getAllPosts();
//    }

//Pagination and sorting
    @GetMapping
    public PostResponse getAllPosts(@RequestParam(value="pageNo",defaultValue = "0",required = false) int pageNo,
                                    @RequestParam(value="pageSize",defaultValue = "10",required = false) int pageSize) {

        return postService.getAllPosts(pageNo,pageSize);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Long id) {
        return   ResponseEntity.ok(postService.getPostById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable Long id){
    PostDto updatedPostResponse=postService.updatePost(postDto,id);
        return  ResponseEntity.ok(updatedPostResponse);

    }
@DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        postService.deleteById(id);
        return ResponseEntity.ok("Deleted Post Successfully "+id);
}

}


