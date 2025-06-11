package com.SecureBlog.SecureBlog.dto.User;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class userResponse {
    private String username;
    private String password;
    private String email;
    private int id;
}
