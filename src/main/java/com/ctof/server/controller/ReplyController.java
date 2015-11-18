/*
 *  *****************************************************
 *  Copyright VMware, Inc. 2014.   All Rights Reserved.
 *  ******************************************************
 */

package com.ctof.server.controller;

import com.ctof.server.exception.NotFoundException;
import com.ctof.server.model.Reply;
import com.ctof.server.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReplyController {
    @Autowired
    private ReplyRepository replyRepository;

    @RequestMapping(value = "/replies", method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    @Transactional
    public Reply create(@RequestBody Reply reply) {
        return replyRepository.save(reply);
    }

    @RequestMapping(value = "/replies", method = RequestMethod.GET)
    @ResponseBody
    @Transactional(readOnly = true)
    public Page<Reply> list(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "pagesize", required = false, defaultValue = "20") Integer pageSize,
            @RequestParam(value = "topicid", required = true) Long topicId) {
        return replyRepository.findByTopicId(topicId, new PageRequest(page - 1, pageSize));
    }

    @RequestMapping(value = "/replies/{id}", method = RequestMethod.GET)
    @ResponseBody
    @Transactional(readOnly = true)
    public Reply read(final @PathVariable Long id) {
        Reply reply = replyRepository.findOne(id);
        if (reply == null) {
            throw new NotFoundException();
        }
        return reply;
    }

    @RequestMapping(value = "/replies/{id}", method = RequestMethod.PUT, headers = {"Content-type=application/json"})
    @ResponseBody
    @Transactional
    public Reply update(final @PathVariable Long id, final @RequestBody Reply updated) {
        Reply reply = replyRepository.findOne(id);
        if (reply == null) {
            throw new NotFoundException();
        }
        if (updated.getTitle() != null) {
            reply.setTitle(updated.getTitle());
        }
        if (updated.getContent() != null) {
            reply.setContent(updated.getContent());
        }
        replyRepository.save(reply);
        return reply;
    }

    @RequestMapping(value = "/replies/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @Transactional
    public void delete(final @PathVariable Long id) {
        replyRepository.delete(id);
    }
}