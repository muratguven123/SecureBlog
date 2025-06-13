package com.SecureBlog.SecureBlog.dto.comment;

import com.SecureBlog.SecureBlog.Entity.User;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class comment_create_request {
    private int postId;        // Hangi post’a yorum yapılıyor
    private String content;     // Yorumun içeriği
}
