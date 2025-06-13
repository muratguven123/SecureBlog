package com.SecureBlog.SecureBlog.Service;

import com.SecureBlog.SecureBlog.Entity.Comment;
import com.SecureBlog.SecureBlog.Entity.Post;
import com.SecureBlog.SecureBlog.Entity.User;
import com.SecureBlog.SecureBlog.dto.comment.CommentUpdateRequest;
import com.SecureBlog.SecureBlog.dto.comment.comment_create_request;
import com.SecureBlog.SecureBlog.dto.comment.commentresponse;
import com.SecureBlog.SecureBlog.mapper.commetmapper;
import com.SecureBlog.SecureBlog.repos.CommentRepository;
import com.SecureBlog.SecureBlog.repos.PostRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private  commentresponse commentresponse;
    private comment_create_request commentCreateRequest;
    private PostRepository postRepository;
    private commetmapper commentmapper;

    public List<commentresponse> getCommentsByPostId(int postId) {
        List<Comment> comments = (List<Comment>) commentRepository.findByPostid(postId);
        return comments.stream()
                .map(commentmapper::toDto)
                .toList();
    }



    public commentresponse addComment(comment_create_request request, User user){
        Post post = postRepository.findById(request.getPostId())
                .orElseThrow(() -> new RuntimeException("Post not found"));
        Comment comment = new Comment();
        comment.setText(request.getContent());
        comment.setAuthor(user);
        comment.setPost(post);
        Comment saved = commentRepository.save(comment);
        return commentmapper.toDto(saved);

    }

    public void deleteComment(int commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
        commentRepository.delete(comment);
    }
    public commentresponse updateComment(CommentUpdateRequest request, User user) {
        Comment comment = commentRepository.findById(request.getCommentId())
                .orElseThrow(() -> new RuntimeException("Comment not found"));

        // Güvenlik: Yorumu sadece yazan kişi güncelleyebilir
        if (!(comment.getAuthor().getId()==user.getId())) {
            throw new RuntimeException("Unauthorized to update this comment");
        }

        comment.setText(request.getNewContent());
        Comment updated = commentRepository.save(comment);
        return commentmapper.toDto(updated);
    }

}
