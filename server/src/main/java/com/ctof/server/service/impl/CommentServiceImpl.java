package com.ctof.server.service.impl;

import com.ctof.api.Comment;
import com.ctof.api.CreateCommentRequest;
import com.ctof.api.UpdateCommentRequest;
import com.ctof.server.model.CommentModel;
import com.ctof.server.repository.CommentRepository;
import com.ctof.server.service.CommentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository repo;
    @Autowired
    private ModelMapper mapper;

    @Override
    public Page<Comment> list(Pageable pageable) {
        Page<CommentModel> commentModels = repo.findAll(pageable);
        Type pageType = new TypeToken<Page<Comment>>() {
        }.getType();
        return mapper.map(commentModels, pageType);
    }

    @Override
    public Comment create(CreateCommentRequest request) {
        CommentModel commentModel = mapper.map(request, CommentModel.class);
        commentModel = repo.save(commentModel);
        mapper.getConfiguration();
        return mapper.map(commentModel, Comment.class);
    }

    @Override
    public Comment get(Long id) {
        return mapper.map(repo.findOne(id), Comment.class);
    }

    @Override
    public Comment update(Long id, UpdateCommentRequest request) {
        CommentModel commentModel = repo.findOne(id);
        mapper.map(request, commentModel);
        commentModel = repo.save(commentModel);
        return mapper.map(commentModel, Comment.class);
    }

    @Override
    public void delete(Long id) {
        repo.delete(id);
    }
}
