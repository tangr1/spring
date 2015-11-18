package com.ctof.server.repository;

import com.ctof.server.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    Page<User> findByStartupId(Long startupId, Pageable pageable);

    User findByEmail(String email);
}