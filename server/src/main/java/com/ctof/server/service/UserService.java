package com.ctof.server.service;

import com.ctof.api.CreateUserRequest;
import com.ctof.api.UpdateUserRequest;
import com.ctof.api.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Page<User> list(Pageable pageable);

    Page<User> listByStartupId(Long startupId, Pageable pageable);

    User create(CreateUserRequest request);

    User get(Long id);

    User update(Long id, UpdateUserRequest request);

    void delete(Long id);
}
