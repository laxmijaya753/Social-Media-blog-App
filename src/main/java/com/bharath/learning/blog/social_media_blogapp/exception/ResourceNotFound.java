package com.bharath.learning.blog.social_media_blogapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound  extends RuntimeException{
    private  String resourceName;
    private String fieldName;
    private String fieldValue;

    public ResourceNotFound(String resourceName, String fieldName, String fieldValue) {
        super(String.format("%s Not found with %s::%s",resourceName,fieldName,fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
