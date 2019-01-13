package com.bigpanda.listenerapp;

import com.bigpanda.logging.SLF4JEnabler;
import com.ulisesbocchio.jasyptspringboot.environment.StandardEncryptableEnvironment;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:application-context.xml"})
public class BlackBoxStatisticsReaderApplication {

    public static void main(String[] args) {
        SLF4JEnabler.enable();
        new SpringApplicationBuilder().environment(new StandardEncryptableEnvironment()).sources(BlackBoxStatisticsReaderApplication.class).run(args);
    }
}
