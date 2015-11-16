package com.vmware.vchs.dbaas.spring.service;

import com.vmware.vchs.dbaas.spring.domain.Reply;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ReplyRepository extends PagingAndSortingRepository<Reply, Long> {
    List<Reply> findByTopicId(long topicId);
}