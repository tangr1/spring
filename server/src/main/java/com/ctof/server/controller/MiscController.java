package com.ctof.server.controller;

import com.ctof.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MiscController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/emails/{name}", method = RequestMethod.HEAD)
    @Transactional(readOnly = true)
    public void checkEmail(final @PathVariable String name) {

    }
}