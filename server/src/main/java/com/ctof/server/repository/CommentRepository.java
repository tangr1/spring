package com.ctof.server.repository;

import com.ctof.server.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {
    Page<Comment> findByReplyId(Long replyId, Pageable pageable);
}