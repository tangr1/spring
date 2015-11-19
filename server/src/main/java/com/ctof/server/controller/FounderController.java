package com.ctof.server.controller;

import com.ctof.api.CreateFounderRequest;
import com.ctof.api.UpdateFounderRequest;
import com.ctof.api.Founder;
import com.ctof.server.service.FounderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class FounderController {
    @Autowired
    private FounderService founderService;

    @RequestMapping(value = "/founders", method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    @Transactional
    public Founder create(final @RequestBody CreateFounderRequest request) {
        return founderService.create(request);
    }

    @RequestMapping(value = "/founders", method = RequestMethod.GET)
    @ResponseBody
    @Transactional(readOnly = true)
    public Page<Founder> list(
            final @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            final @RequestParam(value = "pagesize", required = false, defaultValue = "20") Integer pageSize) {
        return founderService.list(new PageRequest(page - 1, pageSize));
    }

    @RequestMapping(value = "/founders/{id}", method = RequestMethod.GET)
    @ResponseBody
    @Transactional(readOnly = true)
    public Founder read(final @PathVariable Long id) {
        return founderService.get(id);
    }

    @RequestMapping(value = "/founders/{id}", method = RequestMethod.PUT, headers = {"Content-type=application/json"})
    @ResponseBody
    @Transactional
    public Founder update(final @PathVariable Long id, final @RequestBody UpdateFounderRequest request) {
        return founderService.update(id, request);
    }

    @RequestMapping(value = "/founders/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @Transactional
    public void delete(final @PathVariable Long id) {
        founderService.delete(id);
    }
}