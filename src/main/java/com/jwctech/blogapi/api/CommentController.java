package com.jwctech.blogapi.api;

import com.jwctech.blogapi.payload.CommentPayload;

import com.jwctech.blogapi.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentPayload> createComment(
            @PathVariable(value = "postId") Long postId,
            @RequestBody CommentPayload commentPayload) {
        return new ResponseEntity<>(commentService.createComment(postId, commentPayload),
                HttpStatus.CREATED);
    }
    @GetMapping("/posts/{postId}/comments")
    public List<CommentPayload> getCommentsByPostId(@PathVariable(name = "postId")Long postId){
        return commentService.getCommentsByPostId(postId);
    }
}
