package com.bharath.learning.blog.social_media_blogapp.serviceimpl;

import com.bharath.learning.blog.social_media_blogapp.dto.PostDto;
import com.bharath.learning.blog.social_media_blogapp.entity.Post;
import com.bharath.learning.blog.social_media_blogapp.exception.ResourceNotFound;
import com.bharath.learning.blog.social_media_blogapp.pageLoad.PostResponse;
import com.bharath.learning.blog.social_media_blogapp.repository.PostRepository;
import com.bharath.learning.blog.social_media_blogapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;

import static com.bharath.learning.blog.social_media_blogapp.pageLoad.PostResponse.*;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Override
    public PostDto createPost(PostDto postDto) {
        //Map PostDto as entity
     Post post=   mapDtoToEntity(postDto);

        //Save to DB
     Post savedPost=  postRepository.save(post);
        //Map the entity to Post Dto

//        PostDto savedPostDto=new PostDto();
//        savedPostDto.setId(savedPost.getId());
//        savedPostDto.setTitle(savedPost.getTitle());
//        savedPostDto.setDescription(savedPost.getDescription());
//        savedPostDto.setContent(savedPost.getContent());
       PostDto savedPostDto= mapEntityToPostDto(savedPost);
        return  savedPostDto;
    }



    @Override




    public PostResponse getAllPosts(int pageNo,int pageSize,String sortBy,String sortDir) {
        Pageable pageable;
        if(sortBy !=null && sortDir!=null){
            Sort sort=sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
            pageable= PageRequest.of(pageNo,pageSize,sort);
        }
        else{
            pageable= PageRequest.of(pageNo,pageSize);
        }

     Page<Post> allPosts=  postRepository.findAll(pageable);
            //Map PostEntity to PostDto
    List<PostDto>  listpostDto= allPosts.stream().map(post->mapEntityToPostDto(post)).collect(Collectors.toList());

        //Cutomise PostResponse
        PostResponse postResponse= PostResponse
                .builder()
                .content(listpostDto)
                .pageNo(allPosts.getNumber())
                .pageSize(allPosts.getSize())
                .totalElements(allPosts.getTotalElements())
                .totalPages(allPosts.getTotalPages())
                .isLastPage(allPosts.isLast())
                .build();
    return postResponse;
    }

//    public List<PostDto> getAllPosts() {
//      List<Post> allPosts=  postRepository.findAll();
//             //Map PostEntity to PostDto
//      List<PostDto>  listpostDto= allPosts.stream().map(post->mapEntityToPostDto(post)).collect(Collectors.toList());
//        return listpostDto;
//    }

    @Override
    public PostDto getPostById(Long id) {
       Post post=postRepository.findById(id).orElseThrow(()->new ResourceNotFound("Post","id",String.valueOf(id)));
      PostDto postDto= mapEntityToPostDto(post);
        return postDto;

    }

    @Override
    public PostDto updatePost(PostDto postDto, Long id) {
        Post existingPost=postRepository.findById(id).orElseThrow(()->new ResourceNotFound("Post","id",String.valueOf(id)));
        existingPost.setDescription(postDto.getDescription());
        existingPost.setContent(postDto.getContent());
        existingPost.setTitle(postDto.getTitle());
        Post updatedPost1=postRepository.save(existingPost);
        return mapEntityToPostDto(updatedPost1);
    }

    @Override
    public void deleteById(Long id) {
        Post existingPost=postRepository.findById(id).orElseThrow(()->new ResourceNotFound("Post","id",String.valueOf(id)));
        postRepository.delete(existingPost);
    }

    //Map Entity to PostDto
    private PostDto mapEntityToPostDto(Post post){
        PostDto postDto=new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());
        return  postDto;
    }
    //Map PostDto to Entity
    private Post mapDtoToEntity(PostDto postDto) {
        Post post=new Post();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        return post;
    }
}
