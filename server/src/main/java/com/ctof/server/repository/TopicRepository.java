package com.ctof.server.repository;

import com.ctof.server.model.TopicModel;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "topics")
public interface TopicRepository extends PagingAndSortingRepository<TopicModel, Long> {
    @Cacheable
    Page<TopicModel> findByCategory(String category, Pageable pageable);

    @Cacheable
    Page<TopicModel> findByUserId(Long userId, Pageable pageable);

    @Cacheable
    Page<TopicModel> findByStartupId(Long startupId, Pageable pageable);

    @Cacheable
    Page<TopicModel> findByUserIdAndCategory(Long userId, String category, Pageable pageable);
}