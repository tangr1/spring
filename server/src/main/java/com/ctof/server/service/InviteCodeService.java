package com.ctof.server.service;

import com.ctof.api.CreateInviteCodeRequest;
import com.ctof.api.InviteCode;
import com.ctof.api.UpdateInviteCodeRequest;

public interface InviteCodeService {
    InviteCode create(CreateInviteCodeRequest request);
    InviteCode get(Long id);
    InviteCode update(Long id, UpdateInviteCodeRequest request);
    void delete(Long id);
}
