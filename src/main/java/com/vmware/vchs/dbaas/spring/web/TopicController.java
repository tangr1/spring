/*
 *  *****************************************************
 *  Copyright VMware, Inc. 2014.   All Rights Reserved.
 *  ******************************************************
 */

package com.vmware.vchs.dbaas.spring.web;

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
public class TopicController {
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private ReplyRepository replyRepository;

    @RequestMapping(value = "/topics", method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    @Transactional
    public Topic create(@RequestBody Topic topic) {
        return topicRepository.save(topic);
    }

    @RequestMapping(value = "/topics", method = RequestMethod.GET)
    @ResponseBody
    @Transactional(readOnly = true)
    public List<Topic> list() {
        List<Topic> topics = new ArrayList<>();
        for (Topic topic : topicRepository.findAll()) {
            topics.add(topic);
        }
        return topics;
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.GET)
    @ResponseBody
    @Transactional(readOnly = true)
    public Topic read(final @PathVariable Long id) {
        Topic topic = topicRepository.findOne(id);
        if (topic == null) {
            throw new NotFoundException();
        }
        return topic;
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.PUT, headers = {"Content-type=application/json"})
    @ResponseBody
    @Transactional
    public Topic update(final @PathVariable Long id, final @RequestBody Topic updated) {
        Topic topic = topicRepository.findOne(id);
        if (topic == null) {
            throw new NotFoundException();
        }
        if (updated.getTitle() != null) {
            topic.setTitle(updated.getTitle());
        }
        if (updated.getBody() != null) {
            topic.setBody(updated.getBody());
        }
        topicRepository.save(topic);
        return topic;
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @Transactional
    public void delete(final @PathVariable Long id) {
        topicRepository.delete(id);
    }
}