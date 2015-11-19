package com.ctof.server.controller;

import com.ctof.api.CreateInviteCodeRequest;
import com.ctof.api.InviteCode;
import com.ctof.api.UpdateInviteCodeRequest;
import com.ctof.server.service.InviteCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class InviteCodeController {
    @Autowired
    private InviteCodeService inviteCodeService;

    @RequestMapping(value = "/invitecodes", method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    @Transactional
    public InviteCode create(final @RequestBody CreateInviteCodeRequest request) {
        return inviteCodeService.create(request);
    }

    @RequestMapping(value = "/invitecodes/{id}", method = RequestMethod.GET)
    @ResponseBody
    @Transactional(readOnly = true)
    public InviteCode read(final @PathVariable Long id) {
        return inviteCodeService.get(id);
    }

    @RequestMapping(value = "/invitecodes/{id}", method = RequestMethod.PUT, headers = {"Content-type=application/json"})
    @ResponseBody
    @Transactional
    public InviteCode update(final @PathVariable Long id, final @RequestBody UpdateInviteCodeRequest request) {
        return inviteCodeService.update(id, request);
    }

    @RequestMapping(value = "/invitecodes/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @Transactional
    public void delete(final @PathVariable Long id) {
        inviteCodeService.delete(id);
    }
}