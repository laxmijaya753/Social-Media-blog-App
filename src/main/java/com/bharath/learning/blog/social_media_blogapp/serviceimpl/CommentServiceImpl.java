package com.bharath.learning.blog.social_media_blogapp.serviceimpl;

import com.bharath.learning.blog.social_media_blogapp.dto.CommentDto;
import com.bharath.learning.blog.social_media_blogapp.dto.PostDto;
import com.bharath.learning.blog.social_media_blogapp.entity.Comment;
import com.bharath.learning.blog.social_media_blogapp.entity.Post;
import com.bharath.learning.blog.social_media_blogapp.exception.ResourceNotFound;
import com.bharath.learning.blog.social_media_blogapp.repository.CommentRepository;
import com.bharath.learning.blog.social_media_blogapp.repository.PostRepository;
import com.bharath.learning.blog.social_media_blogapp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;






    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {
        //map commentDto to commentEntity
     Comment comment= mapDtoToEntity(commentDto);
     //Fetch post from postrepository using postid request from uri
        Post post=postRepository.findById(postId).orElseThrow(()->new ResourceNotFound("Post","id",String.valueOf(postId)));
        //set comment to post
        comment.setPost(post);
        //save to db
      Comment savedCommentEntity=commentRepository.save(comment);
      //map commenteEntity to commentDto
     CommentDto savedCommentDto=mapEntityToDto(savedCommentEntity);
        return savedCommentDto;
    }

    @Override
    public List<CommentDto> getAllCommentsyPostId(long postId) {
      List<Comment> comments= commentRepository.findByPostId(postId);
      //map Entity to Dto
        List<CommentDto> commentDtoList=comments.stream().map(comment->mapEntityToDto(comment)).collect(Collectors.toList());
        return commentDtoList;
    }

    private CommentDto mapEntityToDto(Comment  comment) {
        CommentDto commentDto=new CommentDto();
        commentDto.setId( comment.getId());
        commentDto.setName(comment.getName());
        commentDto.setEmail(comment.getEmail());
        commentDto.setBody(comment.getBody());
        return  commentDto;
    }

    private Comment mapDtoToEntity(CommentDto  commentDto) {
        Comment comment=new Comment();
        Comment.setId(commentDto.getId());
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());
        return comment;
    }

}
