package com.ctof.server.repository;

import com.ctof.server.model.Startup;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StartupRepository extends PagingAndSortingRepository<Startup, Long> {
}