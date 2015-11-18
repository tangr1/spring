/*
 *  *****************************************************
 *  Copyright VMware, Inc. 2014.   All Rights Reserved.
 *  ******************************************************
 */

package com.ctof.server.controller;

import com.ctof.server.exception.NotFoundException;
import com.ctof.server.model.Startup;
import com.ctof.server.repository.StartupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class StartupController {
    @Autowired
    private StartupRepository startupRepository;

    @RequestMapping(value = "/startups", method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    @Transactional
    public Startup create(@RequestBody Startup startup) {
        return startupRepository.save(startup);
    }

    @RequestMapping(value = "/startups", method = RequestMethod.GET)
    @ResponseBody
    @Transactional(readOnly = true)
    public Page<Startup> list(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "pagesize", required = false, defaultValue = "20") Integer pageSize) {
        return startupRepository.findAll(new PageRequest(page - 1, pageSize));
    }

    @RequestMapping(value = "/startups/{id}", method = RequestMethod.GET)
    @ResponseBody
    @Transactional(readOnly = true)
    public Startup read(final @PathVariable Long id) {
        Startup startup = startupRepository.findOne(id);
        if (startup == null) {
            throw new NotFoundException();
        }
        return startup;
    }

    @RequestMapping(value = "/startups/{id}", method = RequestMethod.PUT, headers = {"Content-type=application/json"})
    @ResponseBody
    @Transactional
    public Startup update(final @PathVariable Long id, final @RequestBody Startup updated) {
        Startup startup = startupRepository.findOne(id);
        if (startup == null) {
            throw new NotFoundException();
        }
        if (updated.getName() != null) {
            startup.setName(updated.getName());
        }
        startupRepository.save(startup);
        return startup;
    }

    @RequestMapping(value = "/startups/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @Transactional
    public void delete(final @PathVariable Long id) {
        startupRepository.delete(id);
    }
}