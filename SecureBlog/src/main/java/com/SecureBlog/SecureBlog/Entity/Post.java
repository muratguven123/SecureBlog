package com.SecureBlog.SecureBlog.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(catalog = "/post")
@Setter
@Getter
@Data
public class Post {
    @Id
    @GeneratedValue
    private int id;

    private String title;
    private String content;
    private int createdAt;


}
