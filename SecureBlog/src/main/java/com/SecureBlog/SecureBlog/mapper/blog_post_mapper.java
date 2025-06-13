package com.SecureBlog.SecureBlog.mapper;

import com.SecureBlog.SecureBlog.Entity.Post;
import com.SecureBlog.SecureBlog.dto.post.PostCreateRequest;
import com.SecureBlog.SecureBlog.dto.post.post_update_request;
import com.SecureBlog.SecureBlog.dto.post.postresponse;
import org.springframework.stereotype.Component;

@Component
public class blog_post_mapper {
    public Post toEntity(PostCreateRequest postCreateRequest, post_update_request postUpdateRequest) {
        Post post = new Post();
        post.setTitle(postCreateRequest.getTitle());
        post.setContent(postCreateRequest.getContent());
        post.setCreatedAt(postUpdateRequest.getDate());
        return post;
    }
    public PostCreateRequest toPostCreateRequest(Post post) {
        PostCreateRequest postCreateRequest = new PostCreateRequest();
        postCreateRequest.setTitle(post.getTitle());
        postCreateRequest.setContent(post.getContent());
        return postCreateRequest;
    }
    public post_update_request toPostUpdateRequest(Post post) {
        post_update_request postUpdateRequest = new post_update_request();
        postUpdateRequest.setTitle(post.getTitle());
        postUpdateRequest.setContent(post.getContent());
        return postUpdateRequest;
    }
    public postresponse toDto(Post post) {
        postresponse postresponse = new postresponse();
        postresponse.setTitle(post.getTitle());
        postresponse.setPost(post.getContent());
        postresponse.setPostid(post.getId());
        return postresponse;
    }
    public Post toEntity(postresponse postresponse) {
        Post post = new Post();
        post.setTitle(postresponse.getTitle());
        post.setContent(postresponse.getPost());
        post.setCreatedAt(postresponse.getTime());
        return post;
    }
}
