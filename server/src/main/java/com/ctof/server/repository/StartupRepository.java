package com.ctof.server.repository;

import com.ctof.server.model.StartupModel;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StartupRepository extends PagingAndSortingRepository<StartupModel, Long> {
}