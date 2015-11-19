package com.ctof.server.controller;

import com.ctof.api.CreateTopicRequest;
import com.ctof.api.Topic;
import com.ctof.api.UpdateTopicRequest;
import com.ctof.server.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class TopicController {
    @Autowired
    private TopicService topicService;

    @RequestMapping(value = "/topics", method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    @Transactional
    public Topic create(final @RequestBody CreateTopicRequest request) {
        return topicService.create(request);
    }

    @RequestMapping(value = "/topics", method = RequestMethod.GET)
    @ResponseBody
    @Transactional(readOnly = true)
    public Page<Topic> list(
            final @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            final @RequestParam(value = "pagesize", required = false, defaultValue = "20") Integer pageSize,
            final @RequestParam(value = "startupid", required = false) Long startupId) {
        if (startupId != null) {
            return topicService.listByStartupId(startupId, new PageRequest(page - 1, pageSize));
        } else {
            return topicService.list(new PageRequest(page - 1, pageSize));
        }
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.GET)
    @ResponseBody
    @Transactional(readOnly = true)
    public Topic read(final @PathVariable Long id) {
        return topicService.get(id);
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.PUT, headers = {"Content-type=application/json"})
    @ResponseBody
    @Transactional
    public Topic update(final @PathVariable Long id, final @RequestBody UpdateTopicRequest request) {
        return topicService.update(id, request);
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @Transactional
    public void delete(final @PathVariable Long id) {
        topicService.delete(id);
    }
}