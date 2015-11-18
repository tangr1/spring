package com.ctof.server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Access token is wrong")  // 401
public class UnAuthorizedException extends RuntimeException {
}
