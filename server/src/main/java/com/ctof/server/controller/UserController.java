/*
 *  *****************************************************
 *  Copyright VMware, Inc. 2014.   All Rights Reserved.
 *  ******************************************************
 */

package com.ctof.server.controller;

import com.ctof.server.exception.NotFoundException;
import com.ctof.server.model.User;
import com.ctof.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/users", method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    @Transactional
    @PreAuthorize("hasAnyRole('ADMIN', 'ROOT')")
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    @Transactional(readOnly = true)
    public Page<User> list(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize,
            @RequestParam(value = "startupId", required = true) Long startupId) {
        if (startupId != null) {
            return userRepository.findByStartupId(startupId, new PageRequest(page - 1, pageSize));
        } else {
            return userRepository.findAll(new PageRequest(page - 1, pageSize));
        }
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    @ResponseBody
    @Transactional(readOnly = true)
    public User read(final @PathVariable Long id) {
        User user = userRepository.findOne(id);
        if (user == null) {
            throw new NotFoundException();
        }
        return user;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT, headers = {"Content-type=application/json"})
    @ResponseBody
    @Transactional
    public User update(final @PathVariable Long id, final @RequestBody User updated) {
        User user = userRepository.findOne(id);
        if (user == null) {
            throw new NotFoundException();
        }
        if (updated.getName() != null) {
            user.setName(updated.getName());
        }
        if (updated.getPhone() != null) {
            user.setPhone(updated.getPhone());
        }
        if (updated.getEmail() != null) {
            user.setEmail(updated.getEmail());
        }
        if (updated.getRole() != null) {
            user.setRole(updated.getRole());
        }
        if (updated.getStartupId() != null) {
            user.setStartupId(updated.getStartupId());
        }
        userRepository.save(user);
        return user;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @Transactional
    public void delete(final @PathVariable Long id) {
        userRepository.delete(id);
    }
}