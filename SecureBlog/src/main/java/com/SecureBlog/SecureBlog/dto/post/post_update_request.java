package com.SecureBlog.SecureBlog.dto.post;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class post_update_request {
    private int id;
    private String title;
    private String content;
    private String author;
    private int date;

}
