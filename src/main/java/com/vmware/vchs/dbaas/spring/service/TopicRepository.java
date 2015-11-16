/*
 *  *****************************************************
 *  Copyright VMware, Inc. 2014.   All Rights Reserved.
 *  ******************************************************
 */

package com.vmware.vchs.dbaas.spring.service;

import com.vmware.vchs.dbaas.spring.domain.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TopicRepository extends PagingAndSortingRepository<Topic, Long> {
    Page<Topic> findByCategory(String category, Pageable pageable);

    Page<Topic> findByUserId(Long userId, Pageable pageable);

    Page<Topic> findByUserIdAndCategory(Long userId, String category, Pageable pageable);

    Page<Topic> findAll(Pageable pageable);
}
