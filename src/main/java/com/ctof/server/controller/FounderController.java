/*
 *  *****************************************************
 *  Copyright VMware, Inc. 2014.   All Rights Reserved.
 *  ******************************************************
 */

package com.ctof.server.controller;

import com.ctof.server.model.Founder;
import com.ctof.server.exception.NotFoundException;
import com.ctof.server.model.Startup;
import com.ctof.server.repository.FounderRepository;
import com.ctof.server.repository.StartupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class FounderController {
    @Autowired
    private FounderRepository founderRepository;
    @Autowired
    private StartupRepository startupRepository;

    @RequestMapping(value = "/founders", method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    @Transactional
    public Founder create(@RequestBody Founder founder) {
        Startup startup = startupRepository.findOne(founder.getStartupId());
        if (startup == null) {
            throw new NotFoundException();
        }
        return founderRepository.save(founder);
    }

    @RequestMapping(value = "/founders", method = RequestMethod.GET)
    @ResponseBody
    @Transactional(readOnly = true)
    public Page<Founder> list(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "pagesize", required = false, defaultValue = "20") Integer pageSize,
            @RequestParam(value = "startupid", required = true) Long startupId) {
        return founderRepository.findByStartupId(startupId, new PageRequest(page - 1, pageSize));
    }

    @RequestMapping(value = "/founders/{id}", method = RequestMethod.GET)
    @ResponseBody
    @Transactional(readOnly = true)
    public Founder read(final @PathVariable Long id) {
        Founder founder = founderRepository.findOne(id);
        if (founder == null) {
            throw new NotFoundException();
        }
        return founder;
    }

    @RequestMapping(value = "/founders/{id}", method = RequestMethod.PUT, headers = {"Content-type=application/json"})
    @ResponseBody
    @Transactional
    public Founder update(final @PathVariable Long id, final @RequestBody Founder updated) {
        Founder founder = founderRepository.findOne(id);
        if (founder == null) {
            throw new NotFoundException();
        }
        if (updated.getName() != null) {
            founder.setName(updated.getName());
        }
        if (updated.getEmail() != null) {
            founder.setEmail(updated.getEmail());
        }
        if (updated.getPosition() != null) {
            founder.setPosition(updated.getPosition());
        }
        if (updated.getIntro() != null) {
            founder.setIntro(updated.getIntro());
        }
        if (updated.getStartupId() != null) {
            founder.setStartupId(updated.getStartupId());
        }
        founderRepository.save(founder);
        return founder;
    }

    @RequestMapping(value = "/founders/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @Transactional
    public void delete(final @PathVariable Long id) {
        founderRepository.delete(id);
    }
}