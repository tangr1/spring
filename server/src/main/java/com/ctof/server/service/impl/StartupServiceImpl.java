package com.ctof.server.service.impl;

import com.ctof.api.CreateStartupRequest;
import com.ctof.api.Startup;
import com.ctof.api.UpdateStartupRequest;
import com.ctof.server.model.StartupModel;
import com.ctof.server.repository.StartupRepository;
import com.ctof.server.service.StartupService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;

@Service
public class StartupServiceImpl implements StartupService {
    @Autowired
    private StartupRepository repo;
    @Autowired
    private ModelMapper mapper;

    @Override
    public Page<Startup> list(Pageable pageable) {
        Page<StartupModel> startupModels = repo.findAll(pageable);
        Type pageType = new TypeToken<Page<Startup>>() {
        }.getType();
        return mapper.map(startupModels, pageType);
    }

    @Override
    public Startup create(CreateStartupRequest request) {
        StartupModel startupModel = mapper.map(request, StartupModel.class);
        startupModel = repo.save(startupModel);
        mapper.getConfiguration();
        return mapper.map(startupModel, Startup.class);
    }

    @Override
    public Startup get(Long id) {
        return mapper.map(repo.findOne(id), Startup.class);
    }

    @Override
    public Startup update(Long id, UpdateStartupRequest request) {
        StartupModel startupModel = repo.findOne(id);
        mapper.map(request, startupModel);
        startupModel = repo.save(startupModel);
        return mapper.map(startupModel, Startup.class);
    }

    @Override
    public void delete(Long id) {
        repo.delete(id);
    }
}
