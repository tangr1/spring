package com.ctof.server.service;

import com.ctof.api.CreateFounderRequest;
import com.ctof.api.Founder;
import com.ctof.api.UpdateFounderRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FounderService {
    Page<Founder> list(Pageable pageable);

    Founder create(CreateFounderRequest request);

    Founder get(Long id);

    Founder update(Long id, UpdateFounderRequest request);

    void delete(Long id);
}
