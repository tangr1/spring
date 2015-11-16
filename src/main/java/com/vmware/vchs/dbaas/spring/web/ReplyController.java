/*
 *  *****************************************************
 *  Copyright VMware, Inc. 2014.   All Rights Reserved.
 *  ******************************************************
 */

package com.vmware.vchs.dbaas.spring.web;

import com.vmware.vchs.dbaas.spring.domain.Reply;
import com.vmware.vchs.dbaas.spring.domain.Topic;
import com.vmware.vchs.dbaas.spring.exception.NotFoundException;
import com.vmware.vchs.dbaas.spring.service.ReplyRepository;
import com.vmware.vchs.dbaas.spring.service.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ReplyController {
    @Autowired
    private ReplyRepository replyRepository;
    @Autowired
    private TopicRepository topicRepository;

    @RequestMapping(value = "/topics/{topicId}/replies", method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    @ResponseBody
    @Transactional
    public Reply create(final @PathVariable Long topicId, @RequestBody Reply reply) {
        Topic topic = topicRepository.findOne(topicId);
        if (topic == null) {
            throw new NotFoundException();
        }
        reply.setTopic(topic);
        replyRepository.save(reply);
        return reply;
    }

    @RequestMapping(value = "/topics/{topicId}/replies", method = RequestMethod.GET)
    @ResponseBody
    @Transactional(readOnly = true)
    public List<Reply> list(final @PathVariable Long topicId) {
        return replyRepository.findByTopicId(topicId);
    }

    @RequestMapping(value = "/topics/{topicId}/replies/{id}", method = RequestMethod.GET)
    @ResponseBody
    @Transactional(readOnly = true)
    public Reply read(final @PathVariable Long topicId, final @PathVariable Long id) {
        Reply instance = replyRepository.findOne(id);
        if (instance == null) {
            throw new NotFoundException();
        }
        return instance;
    }

    @RequestMapping(value = "/topics/{topicId}/replies/{id}", method = RequestMethod.PUT,
            headers = {"Content-type=application/json"})
    @ResponseBody
    @Transactional
    public Reply update(final @PathVariable Long topicId, final @PathVariable Long id,
                        final @RequestBody Reply updated) {
        Reply reply = replyRepository.findOne(id);
        if (reply == null) {
            throw new NotFoundException();
        }
        if (updated.getTitle() != null) {
            reply.setTitle(updated.getTitle());
        }
        if (updated.getBody() != null) {
            reply.setBody(updated.getBody());
        }
        replyRepository.save(reply);
        return reply;
    }

    @RequestMapping(value = "/topics/{topicId}/replies/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @Transactional
    public void delete(final @PathVariable Long topicId, final @PathVariable Long id) {
        replyRepository.delete(id);
    }
}