package com.vmware.vchs.dbaas.spring.service;

import com.vmware.vchs.dbaas.spring.domain.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {
    Page<Comment> findByReplyId(Long replyId, Pageable pageable);
}