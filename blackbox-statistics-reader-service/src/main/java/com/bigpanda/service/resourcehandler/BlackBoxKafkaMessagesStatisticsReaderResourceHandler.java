package com.bigpanda.service.resourcehandler;


import com.bigpanda.commons.web.AbstractResourceHandler;
import com.bigpanda.commons.web.helper.QueryString2BodyHandler;
import com.bigpanda.statisticsreader.service.BlackBoxKafkaMessagesStatisticsReader;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

public class BlackBoxKafkaMessagesStatisticsReaderResourceHandler extends AbstractResourceHandler {

    private BlackBoxKafkaMessagesStatisticsReader blackBoxKafkaMessagesStatisticsReader;

    public void setBlackBoxKafkaMessagesStatisticsReader(BlackBoxKafkaMessagesStatisticsReader BlackBoxKafkaMessagesStatisticsReader) {
        this.blackBoxKafkaMessagesStatisticsReader = BlackBoxKafkaMessagesStatisticsReader;
    }

    @Override
    public Router createRouter(Vertx vertx) {

        Router router = Router.router(vertx);

        router.get("/data").handler(QueryString2BodyHandler.create());
        router.get("/data").handler(this::handleFetchDataStatistics);
        router.get("/type").handler(QueryString2BodyHandler.create());
        router.get("/type").handler(this::handleFetchTypeStatistics);

        return router;
    }

    private void handleFetchDataStatistics(RoutingContext routingContext) {
        blackBoxKafkaMessagesStatisticsReader.fetchDataStatistics(resultHandler(routingContext, 200));
    }

    private void handleFetchTypeStatistics(RoutingContext routingContext) {
        blackBoxKafkaMessagesStatisticsReader.fetchTypeStatistics(resultHandler(routingContext, 200));
    }


}
