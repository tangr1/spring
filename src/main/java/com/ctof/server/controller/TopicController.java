/*
 *  *****************************************************
 *  Copyright VMware, Inc. 2014.   All Rights Reserved.
 *  ******************************************************
 */

package com.ctof.server.controller;

import com.ctof.server.model.Topic;
import com.ctof.server.exception.NotFoundException;
import com.ctof.server.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class TopicController {
    @Autowired
    private TopicRepository topicRepository;

    @RequestMapping(value = "/topics", method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    @Transactional
    public Topic create(@RequestBody Topic topic) {
        topic.setStatus(Topic.TopicStatus.unconfirmed);
        return topicRepository.save(topic);
    }

    @RequestMapping(value = "/topics", method = RequestMethod.GET)
    @ResponseBody
    @Transactional(readOnly = true)
    public Page<Topic> list(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "pagesize", required = false, defaultValue = "20") Integer pageSize,
            @RequestParam(value = "userid", required = false) Long userId,
            @RequestParam(value = "category", required = false) String category) {
        if (userId != null && category != null) {
            return topicRepository.findByUserIdAndCategory(userId, category, new PageRequest(page - 1, pageSize));
        } else if (userId != null) {
            return topicRepository.findByUserId(userId, new PageRequest(page - 1, pageSize));
        } else if (category != null) {
            return topicRepository.findByCategory(category, new PageRequest(page - 1, pageSize));
        } else {
            return topicRepository.findAll(new PageRequest(page - 1, pageSize));
        }
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
        if (updated.getStatus() != null) {
            topic.setStatus(updated.getStatus());
        }
        if (updated.getReward() != null) {
            topic.setReward(updated.getReward());
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