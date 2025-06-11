package com.SecureBlog.SecureBlog.dto.post;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostCreateRequest {
    private String title;
    private String content;
    private String author;
}
