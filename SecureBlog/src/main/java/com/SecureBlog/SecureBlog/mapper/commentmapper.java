package com.SecureBlog.SecureBlog.mapper;

import com.SecureBlog.SecureBlog.Entity.Comment;
import com.SecureBlog.SecureBlog.dto.comment.comment_create_request;
import org.springframework.stereotype.Component;

@Component
public class commentmapper {

    public Comment toEntity(Comment comment) {
        comment_create_request comment_create_request = new comment_create_request();
        comment.setText(comment_create_request.getComment());
        comment.setUser(comment_create_request.getComment_author());
        return comment;
    }
    public Comment toDto(comment_create_request comment_create_request) {
        Comment comment = new Comment();
        comment_create_request.setComment(comment.getText());
        comment_create_request.setComment_author(comment.getUser());
        comment_create_request.setPostid(comment.getId());
        return comment;
    }
}
