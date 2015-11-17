/*
 *  *****************************************************
 *  Copyright VMware, Inc. 2014.   All Rights Reserved.
 *  ******************************************************
 */

package com.ctof.server.repository;

import com.ctof.server.model.Topic;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

@Component
@CacheConfig(cacheNames = "topics")
public interface TopicRepository extends PagingAndSortingRepository<Topic, Long> {
    Page<Topic> findByCategory(String category, Pageable pageable);

    @Cacheable
    Page<Topic> findByUserId(Long userId, Pageable pageable);

    Page<Topic> findByUserIdAndCategory(Long userId, String category, Pageable pageable);

    Page<Topic> findAll(Pageable pageable);
}
