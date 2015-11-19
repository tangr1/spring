package com.ctof.server.repository;

import com.ctof.server.model.FounderModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FounderRepository extends PagingAndSortingRepository<FounderModel, Long> {
    Page<FounderModel> findByStartupId(Long startupId, Pageable pageable);

    Page<FounderModel> findAll(Pageable pageable);
}