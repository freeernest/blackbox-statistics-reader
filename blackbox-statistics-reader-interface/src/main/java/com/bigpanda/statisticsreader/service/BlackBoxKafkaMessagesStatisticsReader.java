package com.bigpanda.statisticsreader.service;

import io.vertx.codegen.annotations.ProxyClose;
import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

@ProxyGen
@VertxGen
public interface BlackBoxKafkaMessagesStatisticsReader {

    String SERVICE_ADDRESS = "gem.service";

    void fetchDataStatistics(Handler<AsyncResult<JsonObject>> asyncResultHandler);
    void fetchTypeStatistics(Handler<AsyncResult<JsonObject>> asyncResultHandler);

    @ProxyClose
    void close();

}
