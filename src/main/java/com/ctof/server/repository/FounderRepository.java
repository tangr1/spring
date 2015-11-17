package com.ctof.server.repository;

import com.ctof.server.model.Founder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface FounderRepository extends CrudRepository<Founder, Long> {
    Page<Founder> findByStartupId(Long startupId, Pageable pageable);
}