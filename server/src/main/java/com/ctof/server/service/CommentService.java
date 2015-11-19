package com.ctof.server.service;

import com.ctof.api.Comment;
import com.ctof.api.CreateCommentRequest;
import com.ctof.api.UpdateCommentRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentService {
    Page<Comment> list(Pageable pageable);

    Comment create(CreateCommentRequest request);

    Comment get(Long id);

    Comment update(Long id, UpdateCommentRequest request);

    void delete(Long id);
}
