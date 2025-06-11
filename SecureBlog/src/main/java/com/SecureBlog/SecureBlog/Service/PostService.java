package com.SecureBlog.SecureBlog.Service;

import com.SecureBlog.SecureBlog.mapper.blog_post_mapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import repos.PostRepository;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class PostService {
    PostRepository postRepository;
    blog_post_mapper blog_post_mapper;

}
