package com.SecureBlog.SecureBlog.controller;

import com.SecureBlog.SecureBlog.Entity.User;
import com.SecureBlog.SecureBlog.Service.CommentService;
import com.SecureBlog.SecureBlog.dto.comment.CommentUpdateRequest;
import com.SecureBlog.SecureBlog.dto.comment.comment_create_request;
import com.SecureBlog.SecureBlog.dto.comment.commentresponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class commentcontroller {
    private final CommentService commentService;
    private commentresponse commentresponse;
    private comment_create_request commentCreateRequest;
    private User user;

    @PostMapping("/comments")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<commentresponse> addComment(@RequestBody @Valid comment_create_request request,
                                                      @AuthenticationPrincipal User user) {
        commentresponse response = commentService.addComment(request, user);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<commentresponse> updateComment(@RequestBody CommentUpdateRequest request,
                                                         @AuthenticationPrincipal User user) {
        commentresponse response = commentService.updateComment(request, user);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{commentId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<String> deleteComment(@PathVariable int commentId,
                                                @AuthenticationPrincipal User user) {
        commentService.deleteComment(commentId);
        return ResponseEntity.ok("Comment deleted successfully");

    }
}
