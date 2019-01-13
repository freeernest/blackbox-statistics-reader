package com.bigpanda.service.impl;


import com.bigpanda.statisticsreader.service.BlackBoxKafkaMessagesStatisticsReader;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.core.shareddata.AsyncMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Set;

public class BlackBoxKafkaMessagesStatisticsReaderImpl implements BlackBoxKafkaMessagesStatisticsReader {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private Vertx vertx;
    AsyncMap<String, Integer> dataStatisticsMap;
    Set<Map.Entry<String, Integer>> dataStatisticsSet;
    AsyncMap<String, Integer> typeStatisticsMap;
    Set<Map.Entry<String, Integer>> typeStatisticsSet;

    @Override
    public void fetchDataStatistics(Handler<AsyncResult<JsonObject>> resultHandler) {
        if(dataStatisticsMap == null) {
            vertx.sharedData().<String, Integer>getClusterWideMap("dataStatisticsMap",
                    res -> {
                        dataStatisticsMap = res.result();
                        handleGetDataStatisticsResponse(resultHandler);
                    });
        } else {
            handleGetDataStatisticsResponse(resultHandler);
        }
    }

    private void handleGetDataStatisticsResponse(Handler<AsyncResult<JsonObject>> resultHandler) {
        dataStatisticsMap.entries(e -> {
            dataStatisticsSet = e.result().entrySet();
            JsonObject json = new JsonObject();
            dataStatisticsSet.forEach( entity -> json.put(entity.getKey(),entity.getValue()));
            resultHandler.handle(Future.succeededFuture(json));
        });

    }

    @Override
    public void fetchTypeStatistics(Handler<AsyncResult<JsonObject>> resultHandler) {
        if(typeStatisticsMap == null) {
            vertx.sharedData().<String, Integer>getClusterWideMap("typeStatisticsMap",
                    res -> {
                        typeStatisticsMap = res.result();
                        handleGetTypeStatisticsResponse(resultHandler);
                    });
        } else {

            handleGetTypeStatisticsResponse(resultHandler);
        }
    }

    private void handleGetTypeStatisticsResponse(Handler<AsyncResult<JsonObject>> resultHandler) {
        typeStatisticsMap.entries(e -> {
            typeStatisticsSet = e.result().entrySet();
            JsonObject json = new JsonObject();
            typeStatisticsSet.forEach( entity -> json.put(entity.getKey(),entity.getValue()));
            resultHandler.handle(Future.succeededFuture(json));
        });

    }

    @Override
    public void close() {

    }

    public void setVertx(Vertx vertx) {
        this.vertx = vertx;
    }


}
