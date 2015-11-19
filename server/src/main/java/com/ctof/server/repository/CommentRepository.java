package com.ctof.server.repository;

import com.ctof.server.model.CommentModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CommentRepository extends PagingAndSortingRepository<CommentModel, Long> {
    Page<CommentModel> findByReplyId(Long replyId, Pageable pageable);
}