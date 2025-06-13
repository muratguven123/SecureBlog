package com.SecureBlog.SecureBlog.dto.post;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class postresponse {
    private String post;
    private int postid;
    private String title;
    private String postresponse;
    private int time;
}
