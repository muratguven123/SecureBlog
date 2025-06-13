package com.SecureBlog.SecureBlog.controller;

import com.SecureBlog.SecureBlog.Entity.Post;
import com.SecureBlog.SecureBlog.Entity.User;
import com.SecureBlog.SecureBlog.Service.CommentService;
import com.SecureBlog.SecureBlog.Service.PostService;
import com.SecureBlog.SecureBlog.dto.comment.commentresponse;
import com.SecureBlog.SecureBlog.dto.post.PostCreateRequest;
import com.SecureBlog.SecureBlog.dto.post.postresponse;
import com.SecureBlog.SecureBlog.repos.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/post")
@RestController
@RequiredArgsConstructor
public class postcontroller {
    private final PostService postService;
    private final PostRepository postRepository;
    private final com.SecureBlog.SecureBlog.mapper.blog_post_mapper blog_post_mapper;
    private final CommentService commentService;

    @GetMapping("/post")
    @PreAuthorize("hasRole('Admin')")
    public List<Post> getAllPost(){
        return postRepository.findAll();
    }
    @PostMapping("/addpost")
    @PreAuthorize("hasAnyRole('Admin','User')")
    public postresponse addPost(PostCreateRequest request, User user){
        return postService.addPost(request, user);
    }
    @PutMapping
    @PreAuthorize("hasAnyRole('Admin','User')")
    public postresponse updatepost(postresponse postresponse){
        return postService.updatepost(postresponse);
    }
    @DeleteMapping
    @PreAuthorize("hasAnyRole('Admin','User')")
    public void deletemethod(postresponse postresponse){
        Post post= blog_post_mapper.toEntity(postresponse);
        postRepository.delete(post);
    }
    @GetMapping("/{postId}/comments")
    public ResponseEntity<List<commentresponse>> getCommentsForPost(@PathVariable int postId) {
        List<commentresponse> comments = commentService.getCommentsByPostId(postId);
        return ResponseEntity.ok(comments);
    }

}
