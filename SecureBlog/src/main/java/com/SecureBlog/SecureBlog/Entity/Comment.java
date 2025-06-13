package com.SecureBlog.SecureBlog.Entity;

import jakarta.persistence.*;
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
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

}
