package com.ctof.server.controller;

import com.ctof.api.CreateStartupRequest;
import com.ctof.api.Startup;
import com.ctof.api.UpdateStartupRequest;
import com.ctof.server.service.StartupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class StartupController {
    @Autowired
    private StartupService startupService;

    @RequestMapping(value = "/startups", method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    @Transactional
    public Startup create(final @RequestBody CreateStartupRequest request) {
        return startupService.create(request);
    }

    @RequestMapping(value = "/startups", method = RequestMethod.GET)
    @ResponseBody
    @Transactional(readOnly = true)
    public Page<Startup> list(
            final @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            final @RequestParam(value = "pagesize", required = false, defaultValue = "20") Integer pageSize) {
        return startupService.list(new PageRequest(page - 1, pageSize));
    }

    @RequestMapping(value = "/startups/{id}", method = RequestMethod.GET)
    @ResponseBody
    @Transactional(readOnly = true)
    public Startup read(final @PathVariable Long id) {
        return startupService.get(id);
    }

    @RequestMapping(value = "/startups/{id}", method = RequestMethod.PUT, headers = {"Content-type=application/json"})
    @ResponseBody
    @Transactional
    public Startup update(final @PathVariable Long id, final @RequestBody UpdateStartupRequest request) {
        return startupService.update(id, request);
    }

    @RequestMapping(value = "/startups/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @Transactional
    public void delete(final @PathVariable Long id) {
        startupService.delete(id);
    }
}