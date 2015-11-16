package com.vmware.vchs.dbaas.spring.service;

import com.vmware.vchs.dbaas.spring.domain.Reply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ReplyRepository extends PagingAndSortingRepository<Reply, Long> {
    Page<Reply> findByTopicId(long topicId, Pageable pageable);
}