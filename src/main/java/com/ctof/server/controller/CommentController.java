/*
 *  *****************************************************
 *  Copyright VMware, Inc. 2014.   All Rights Reserved.
 *  ******************************************************
 */

package com.ctof.server.controller;

import com.ctof.server.model.Comment;
import com.ctof.server.exception.NotFoundException;
import com.ctof.server.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;

    @RequestMapping(value = "/comments", method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    @Transactional
    public Comment create(@RequestBody Comment comment) {
        return commentRepository.save(comment);
    }

    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    @ResponseBody
    @Transactional(readOnly = true)
    public Page<Comment> list(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "pagesize", required = false, defaultValue = "20") Integer pageSize,
            @RequestParam(value = "topicid", required = true) Long replyId) {
        return commentRepository.findByReplyId(replyId, new PageRequest(page - 1, pageSize));
    }

    @RequestMapping(value = "/comments/{id}", method = RequestMethod.GET)
    @ResponseBody
    @Transactional(readOnly = true)
    public Comment read(final @PathVariable Long id) {
        Comment comment = commentRepository.findOne(id);
        if (comment == null) {
            throw new NotFoundException();
        }
        return comment;
    }

    @RequestMapping(value = "/comments/{id}", method = RequestMethod.PUT, headers = {"Content-type=application/json"})
    @ResponseBody
    @Transactional
    public Comment update(final @PathVariable Long id, final @RequestBody Comment updated) {
        Comment comment = commentRepository.findOne(id);
        if (comment == null) {
            throw new NotFoundException();
        }
        if (updated.getBody() != null) {
            comment.setBody(updated.getBody());
        }
        commentRepository.save(comment);
        return comment;
    }

    @RequestMapping(value = "/comments/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @Transactional
    public void delete(final @PathVariable Long id) {
        commentRepository.delete(id);
    }
}