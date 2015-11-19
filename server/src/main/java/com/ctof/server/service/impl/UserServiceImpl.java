package com.ctof.server.service.impl;

import com.ctof.api.CreateUserRequest;
import com.ctof.api.UpdateUserRequest;
import com.ctof.api.User;
import com.ctof.server.exception.NotFoundException;
import com.ctof.server.model.UserModel;
import com.ctof.server.repository.UserRepository;
import com.ctof.server.service.UserService;
import org.hibernate.annotations.NotFound;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repo;
    @Autowired
    private ModelMapper mapper;

    @Override
    public Page<User> list(Pageable pageable) {
        Page<UserModel> userModels = repo.findAll(pageable);
        Type pageType = new TypeToken<Page<User>>() {
        }.getType();
        return mapper.map(userModels, pageType);
    }

    @Override
    public Page<User> listByStartupId(Long startupId, Pageable pageable) {
        Page<UserModel> userModels = repo.findByStartupId(startupId, pageable);
        Type pageType = new TypeToken<Page<User>>() {
        }.getType();
        return mapper.map(userModels, pageType);
    }

    @Override
    public User create(CreateUserRequest request) {
        UserModel userModel = mapper.map(request, UserModel.class);
        userModel = repo.save(userModel);
        mapper.getConfiguration();
        return mapper.map(userModel, User.class);
    }

    @Override
    public User get(Long id) {
        UserModel userModel = repo.findOne(id);
        if (userModel == null) {
            throw new NotFoundException();
        }
        return mapper.map(repo.findOne(id), User.class);
    }

    @Override
    public User update(Long id, UpdateUserRequest request) {
        UserModel userModel = repo.findOne(id);
        if (userModel == null) {
            throw new NotFoundException();
        }
        mapper.map(request, userModel);
        userModel = repo.save(userModel);
        return mapper.map(userModel, User.class);
    }

    @Override
    public void delete(Long id) {
        UserModel userModel = repo.findOne(id);
        if (userModel == null) {
            throw new NotFoundException();
        }
        repo.delete(id);
    }
}
