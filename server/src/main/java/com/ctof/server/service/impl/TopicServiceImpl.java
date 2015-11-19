package com.ctof.server.service.impl;

import com.ctof.api.CreateTopicRequest;
import com.ctof.api.Topic;
import com.ctof.api.UpdateTopicRequest;
import com.ctof.server.model.TopicModel;
import com.ctof.server.repository.TopicRepository;
import com.ctof.server.service.TopicService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    private TopicRepository repo;
    @Autowired
    private ModelMapper mapper;

    @Override
    public Page<Topic> list(Pageable pageable) {
        Page<TopicModel> topicModels = repo.findAll(pageable);
        Type pageType = new TypeToken<Page<Topic>>() {
        }.getType();
        return mapper.map(topicModels, pageType);
    }

    @Override
    public Page<Topic> listByStartupId(Long startupId, Pageable pageable) {
        Page<TopicModel> topicModels = repo.findByStartupId(startupId, pageable);
        Type pageType = new TypeToken<Page<Topic>>() {
        }.getType();
        return mapper.map(topicModels, pageType);
    }

    @Override
    public Topic create(CreateTopicRequest request) {
        TopicModel topicModel = mapper.map(request, TopicModel.class);
        topicModel = repo.save(topicModel);
        mapper.getConfiguration();
        return mapper.map(topicModel, Topic.class);
    }

    @Override
    public Topic get(Long id) {
        return mapper.map(repo.findOne(id), Topic.class);
    }

    @Override
    public Topic update(Long id, UpdateTopicRequest request) {
        TopicModel topicModel = repo.findOne(id);
        mapper.map(request, topicModel);
        topicModel = repo.save(topicModel);
        return mapper.map(topicModel, Topic.class);
    }

    @Override
    public void delete(Long id) {
        repo.delete(id);
    }
}
