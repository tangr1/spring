package com.ctof.server.service.impl;

import com.ctof.api.CreateReplyRequest;
import com.ctof.api.Reply;
import com.ctof.api.UpdateReplyRequest;
import com.ctof.server.model.ReplyModel;
import com.ctof.server.repository.ReplyRepository;
import com.ctof.server.service.ReplyService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;

@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    private ReplyRepository repo;
    @Autowired
    private ModelMapper mapper;

    @Override
    public Page<Reply> list(Pageable pageable) {
        Page<ReplyModel> replyModels = repo.findAll(pageable);
        Type pageType = new TypeToken<Page<Reply>>() {
        }.getType();
        return mapper.map(replyModels, pageType);
    }

    @Override
    public Reply create(CreateReplyRequest request) {
        ReplyModel replyModel = mapper.map(request, ReplyModel.class);
        replyModel = repo.save(replyModel);
        mapper.getConfiguration();
        return mapper.map(replyModel, Reply.class);
    }

    @Override
    public Reply get(Long id) {
        return mapper.map(repo.findOne(id), Reply.class);
    }

    @Override
    public Reply update(Long id, UpdateReplyRequest request) {
        ReplyModel replyModel = repo.findOne(id);
        mapper.map(request, replyModel);
        replyModel = repo.save(replyModel);
        return mapper.map(replyModel, Reply.class);
    }

    @Override
    public void delete(Long id) {
        repo.delete(id);
    }
}
