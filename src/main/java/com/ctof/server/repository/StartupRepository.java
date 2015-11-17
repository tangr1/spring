package com.ctof.server.repository;

import com.ctof.server.model.Startup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface StartupRepository extends CrudRepository<Startup, Long> {
    Page<Startup> findAll(Pageable pageable);
}