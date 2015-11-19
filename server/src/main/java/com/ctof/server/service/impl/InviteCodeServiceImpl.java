package com.ctof.server.service.impl;

import com.ctof.api.CreateInviteCodeRequest;
import com.ctof.api.InviteCode;
import com.ctof.api.UpdateInviteCodeRequest;
import com.ctof.server.model.InviteCodeModel;
import com.ctof.server.repository.InviteCodeRepository;
import com.ctof.server.service.InviteCodeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InviteCodeServiceImpl implements InviteCodeService {
    @Autowired
    private InviteCodeRepository repo;
    @Autowired
    private ModelMapper mapper;

    @Override
    public InviteCode create(CreateInviteCodeRequest request) {
        InviteCodeModel inviteCodeModel = mapper.map(request, InviteCodeModel.class);
        inviteCodeModel = repo.save(inviteCodeModel);
        mapper.getConfiguration();
        return mapper.map(inviteCodeModel, InviteCode.class);
    }

    @Override
    public InviteCode get(Long id) {
        return mapper.map(repo.findOne(id), InviteCode.class);
    }

    @Override
    public InviteCode update(Long id, UpdateInviteCodeRequest request) {
        InviteCodeModel inviteCodeModel = repo.findOne(id);
        mapper.map(request, inviteCodeModel);
        inviteCodeModel = repo.save(inviteCodeModel);
        return mapper.map(inviteCodeModel, InviteCode.class);
    }

    @Override
    public void delete(Long id) {
        repo.delete(id);
    }
}
