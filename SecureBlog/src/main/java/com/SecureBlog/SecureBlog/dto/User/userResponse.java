package com.SecureBlog.SecureBlog.dto.User;

import com.SecureBlog.SecureBlog.Entity.RoleTypes;
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
    private RoleTypes roleTypes;
}
