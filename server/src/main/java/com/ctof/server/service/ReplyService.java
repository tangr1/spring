package com.ctof.server.service;

import com.ctof.api.CreateReplyRequest;
import com.ctof.api.Reply;
import com.ctof.api.UpdateReplyRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReplyService {
    Page<Reply> list(Pageable pageable);

    Reply create(CreateReplyRequest request);

    Reply get(Long id);

    Reply update(Long id, UpdateReplyRequest request);

    void delete(Long id);
}
