package com.bharath.learning.blog.social_media_blogapp.pageLoad;

import com.bharath.learning.blog.social_media_blogapp.dto.PostDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Builder
public class PostResponse {
  private List<PostDto> content;
    private  int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean isLastPage;
  PostResponse(){

  }

  public PostResponse(List<PostDto> content, int pageNo, int pageSize, long totalElements, int totalPages, boolean isLastPage) {
    this.content = content;
    this.pageNo = pageNo;
    this.pageSize = pageSize;
    this.totalElements = totalElements;
    this.totalPages = totalPages;
    this.isLastPage = isLastPage;
  }




}
