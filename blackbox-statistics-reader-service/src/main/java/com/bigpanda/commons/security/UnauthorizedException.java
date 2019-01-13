package com.bigpanda.commons.security;

import io.vertx.serviceproxy.ServiceException;


public class UnauthorizedException extends ServiceException {

    public static int CODE = UnauthorizedException.class.getName().hashCode();

    public UnauthorizedException() {
        super(CODE, "Unauthorized");
    }
}
