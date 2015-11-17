package com.ctof.server.repository;

import com.ctof.server.model.Reply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ReplyRepository extends PagingAndSortingRepository<Reply, Long> {
    Page<Reply> findByTopicId(long topicId, Pageable pageable);
}