package com.ctof.server.repository;

import com.ctof.server.model.Startup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StartupRepository extends PagingAndSortingRepository<Startup, Long> {
}