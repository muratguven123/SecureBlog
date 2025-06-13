package com.SecureBlog.SecureBlog.Service;

import com.SecureBlog.SecureBlog.Entity.Post;
import com.SecureBlog.SecureBlog.Entity.User;
import com.SecureBlog.SecureBlog.dto.post.PostCreateRequest;
import com.SecureBlog.SecureBlog.dto.post.postresponse;
import com.SecureBlog.SecureBlog.mapper.blog_post_mapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import com.SecureBlog.SecureBlog.repos.PostRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class PostService {
    private  PostRepository postRepository;
    private  blog_post_mapper blog_post_mapper;
    private PasswordEncoder passwordEncoder;

    public List<postresponse> getAllPost(){
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(blog_post_mapper::toDto).toList();
    }
    public postresponse getPostById(int id){
        Post post = postRepository.findById(id).get();
        return blog_post_mapper.toDto(post);
    }
    public postresponse addPost(PostCreateRequest request, User user) {
        Post post = new Post();
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        post.setAuthor(request.getAuthor());
        post.setCreatedAt(request.getTime());
        Post savedPost = postRepository.save(post);
        return blog_post_mapper.toDto(savedPost);
    }

    public postresponse updatepost(postresponse postresponse){
        Post post = postRepository.findById(postresponse.getPostid()).orElseThrow(()->new RuntimeException("Post is not Found"));
        post.setId(postresponse.getPostid());
        post.setContent(postresponse.getPost());
        post.setCreatedAt(postresponse.getTime());
        return blog_post_mapper.toDto(post);
    }
    public void deletepost(postresponse postresponse){
        Post post = postRepository.findById(postresponse.getPostid()).orElseThrow(()->new RuntimeException("Post Cannot be deleted becasuse already not found it"));
        postRepository.delete(post);
    }

}
