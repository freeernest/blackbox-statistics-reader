package com.bigpanda.commons.security;

import io.vertx.serviceproxy.ServiceException;


public class ForbiddenException extends ServiceException {

    public static int CODE = ForbiddenException.class.getName().hashCode();

    public ForbiddenException() {
        super(CODE, "Forbidden");
    }
}
