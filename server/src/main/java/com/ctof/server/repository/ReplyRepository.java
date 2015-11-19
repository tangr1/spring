package com.ctof.server.repository;

import com.ctof.server.model.ReplyModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ReplyRepository extends PagingAndSortingRepository<ReplyModel, Long> {
    Page<ReplyModel> findByTopicId(long topicId, Pageable pageable);
}