package com.SecureBlog.SecureBlog.dto.comment;

import lombok.Data;

@Data
public class CommentUpdateRequest {
    private int commentId;
    private String newContent;
}
