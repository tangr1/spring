package com.ctof.server.controller;

import com.ctof.api.CreateReplyRequest;
import com.ctof.api.Reply;
import com.ctof.api.UpdateReplyRequest;
import com.ctof.server.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    @RequestMapping(value = "/replies", method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    @Transactional
    public Reply create(final @RequestBody CreateReplyRequest request) {
        return replyService.create(request);
    }

    @RequestMapping(value = "/replies", method = RequestMethod.GET)
    @ResponseBody
    @Transactional(readOnly = true)
    public Page<Reply> list(
            final @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            final @RequestParam(value = "pagesize", required = false, defaultValue = "20") Integer pageSize) {
        return replyService.list(new PageRequest(page - 1, pageSize));
    }

    @RequestMapping(value = "/replies/{id}", method = RequestMethod.GET)
    @ResponseBody
    @Transactional(readOnly = true)
    public Reply read(final @PathVariable Long id) {
        return replyService.get(id);
    }

    @RequestMapping(value = "/replies/{id}", method = RequestMethod.PUT, headers = {"Content-type=application/json"})
    @ResponseBody
    @Transactional
    public Reply update(final @PathVariable Long id, final @RequestBody UpdateReplyRequest request) {
        return replyService.update(id, request);
    }

    @RequestMapping(value = "/replies/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @Transactional
    public void delete(final @PathVariable Long id) {
        replyService.delete(id);
    }
}