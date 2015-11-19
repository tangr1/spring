package com.ctof.server.service;

import com.ctof.api.CreateStartupRequest;
import com.ctof.api.UpdateStartupRequest;
import com.ctof.api.Startup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StartupService {
    Page<Startup> list(Pageable pageable);
    Startup create(CreateStartupRequest request);
    Startup get(Long id);
    Startup update(Long id, UpdateStartupRequest request);
    void delete(Long id);
}
