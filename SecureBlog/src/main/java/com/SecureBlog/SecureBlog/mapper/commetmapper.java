package com.SecureBlog.SecureBlog.mapper;

import com.SecureBlog.SecureBlog.Entity.Comment;
import com.SecureBlog.SecureBlog.dto.comment.comment_create_request;
import com.SecureBlog.SecureBlog.dto.comment.commentresponse;
import org.springframework.stereotype.Component;

@Component
public class commetmapper {

    // DTO → Entity
    public Comment toEntity(comment_create_request request) {
        Comment comment = new Comment();
        comment.setText(request.getContent());
        // post ve author service katmanında setlenir
        return comment;
    }

    // Entity → Response DTO
    public commentresponse toDto(Comment comment) {
        commentresponse response = new commentresponse();
        response.setComment(comment.getText());
        response.setPostid(comment.getId());
        response.setAuthorUsername(comment.getAuthor().getUsername());
        return response;
    }
}
