package com.SecureBlog.SecureBlog.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(catalog = "/comment")
@Getter
@Setter
public class Comment {
    @Getter
    @Setter
    @Id
    private Long id;

    private String text;
    private String post;
    private String user;

}
