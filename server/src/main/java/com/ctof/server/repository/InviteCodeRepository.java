package com.ctof.server.repository;

import com.ctof.server.model.InviteCodeModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface InviteCodeRepository extends PagingAndSortingRepository<InviteCodeModel, Long> {
    Page<InviteCodeModel> findByStartupId(Long startupId, Pageable pageable);
}