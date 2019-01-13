package com.bigpanda.verticles;

import com.bigpanda.statisticsreader.service.BlackBoxKafkaMessagesStatisticsReader;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.MessageConsumer;
import io.vertx.serviceproxy.ServiceBinder;

public class BlackBoxKafkaMessagesStatisticsReaderVerticle extends AbstractVerticle {

    private BlackBoxKafkaMessagesStatisticsReader blackBoxKafkaMessagesStatisticsReader;
    private MessageConsumer consumer;


    @Override
    public void start() throws Exception {
        ServiceBinder serviceBinder = new ServiceBinder(vertx)
                .setAddress(BlackBoxKafkaMessagesStatisticsReader.SERVICE_ADDRESS);

        consumer = serviceBinder.register(BlackBoxKafkaMessagesStatisticsReader.class, blackBoxKafkaMessagesStatisticsReader);
    }

    @Override
    public void stop() throws Exception {
        blackBoxKafkaMessagesStatisticsReader.close();
        consumer.unregister();
    }

    public void setBlackBoxKafkaMessagesStatisticsReader(BlackBoxKafkaMessagesStatisticsReader BlackBoxKafkaMessagesStatisticsReader) {
        this.blackBoxKafkaMessagesStatisticsReader = BlackBoxKafkaMessagesStatisticsReader;
    }
}
