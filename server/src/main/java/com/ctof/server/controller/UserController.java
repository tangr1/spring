package com.ctof.server.controller;

import com.ctof.api.CreateUserRequest;
import com.ctof.api.User;
import com.ctof.api.UpdateUserRequest;
import com.ctof.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    @Transactional
    public User create(final @RequestBody CreateUserRequest request) {
        return userService.create(request);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    @Transactional(readOnly = true)
    public Page<User> list(
            final @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            final @RequestParam(value = "pagesize", required = false, defaultValue = "20") Integer pageSize) {
        return userService.list(new PageRequest(page - 1, pageSize));
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    @ResponseBody
    @Transactional(readOnly = true)
    public User read(final @PathVariable Long id) {
        return userService.get(id);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT, headers = {"Content-type=application/json"})
    @ResponseBody
    @Transactional
    public User update(final @PathVariable Long id, final @RequestBody UpdateUserRequest request) {
        return userService.update(id, request);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @Transactional
    public void delete(final @PathVariable Long id) {
        userService.delete(id);
    }
}