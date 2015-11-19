package com.ctof.server.service;

import com.ctof.api.CreateTopicRequest;
import com.ctof.api.Topic;
import com.ctof.api.UpdateTopicRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TopicService {
    Page<Topic> list(Pageable pageable);
    Topic create(CreateTopicRequest request);
    Topic get(Long id);
    Topic update(Long id, UpdateTopicRequest request);
    void delete(Long id);
}
