package com.ctof.server.controller;

import com.ctof.api.Comment;
import com.ctof.api.CreateCommentRequest;
import com.ctof.api.UpdateCommentRequest;
import com.ctof.server.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/comments", method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    @Transactional
    public Comment create(final @RequestBody CreateCommentRequest request) {
        return commentService.create(request);
    }

    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    @ResponseBody
    @Transactional(readOnly = true)
    public Page<Comment> list(
            final @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            final @RequestParam(value = "pagesize", required = false, defaultValue = "20") Integer pageSize) {
        return commentService.list(new PageRequest(page - 1, pageSize));
    }

    @RequestMapping(value = "/comments/{id}", method = RequestMethod.GET)
    @ResponseBody
    @Transactional(readOnly = true)
    public Comment read(final @PathVariable Long id) {
        return commentService.get(id);
    }

    @RequestMapping(value = "/comments/{id}", method = RequestMethod.PUT, headers = {"Content-type=application/json"})
    @ResponseBody
    @Transactional
    public Comment update(final @PathVariable Long id, final @RequestBody UpdateCommentRequest request) {
        return commentService.update(id, request);
    }

    @RequestMapping(value = "/comments/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @Transactional
    public void delete(final @PathVariable Long id) {
        commentService.delete(id);
    }
}