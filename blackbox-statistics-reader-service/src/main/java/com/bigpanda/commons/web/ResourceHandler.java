package com.bigpanda.commons.web;

import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;


public interface ResourceHandler {
    Router createRouter(Vertx vertx);
}
