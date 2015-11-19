package com.ctof.server.repository;

import com.ctof.server.model.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<UserModel, Long> {
    Page<UserModel> findByStartupId(Long startupId, Pageable pageable);

    UserModel findByEmail(String email);
}