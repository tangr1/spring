package com.ctof.server.service.impl;

import com.ctof.api.CreateFounderRequest;
import com.ctof.api.Founder;
import com.ctof.api.UpdateFounderRequest;
import com.ctof.server.model.FounderModel;
import com.ctof.server.repository.FounderRepository;
import com.ctof.server.service.FounderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;

@Service
public class FounderServiceImpl implements FounderService {
    @Autowired
    private FounderRepository repo;
    @Autowired
    private ModelMapper mapper;

    @Override
    public Page<Founder> list(Pageable pageable) {
        Page<FounderModel> founderModels =  repo.findAll(pageable);
        Type pageType = new TypeToken<Page<Founder>>() {}.getType();
        return mapper.map(founderModels, pageType);
    }

    @Override
    public Founder create(CreateFounderRequest request) {
        FounderModel founderModel = mapper.map(request, FounderModel.class);
        founderModel = repo.save(founderModel);
        mapper.getConfiguration();
        return mapper.map(founderModel, Founder.class);
    }

    @Override
    public Founder get(Long id) {
        return mapper.map(repo.findOne(id), Founder.class);
    }

    @Override
    public Founder update(Long id, UpdateFounderRequest request) {
        FounderModel founderModel = repo.findOne(id);
        mapper.map(request, founderModel);
        founderModel = repo.save(founderModel);
        return mapper.map(founderModel, Founder.class);
    }

    @Override
    public void delete(Long id) {
        repo.delete(id);
    }
}
