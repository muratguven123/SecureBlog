package com.SecureBlog.SecureBlog.dto.User;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class userupdaterequest {
    private int id;
    private String username;
    private String password;
    private String email;
}
