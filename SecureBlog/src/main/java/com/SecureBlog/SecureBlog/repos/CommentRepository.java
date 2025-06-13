package com.SecureBlog.SecureBlog.repos;

import com.SecureBlog.SecureBlog.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    Comment findByPostid(int postid );
}
