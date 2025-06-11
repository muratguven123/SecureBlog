package com.SecureBlog.SecureBlog.dto.comment;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class comment_create_request {
    private String comment;
    private Long postid;
    private String user;
    private String comment_author;
}
