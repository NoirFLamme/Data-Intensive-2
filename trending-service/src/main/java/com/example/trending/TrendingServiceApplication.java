package com.example.trending;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.io.IOException;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class TrendingServiceApplication {

    public static void main(String[] args) throws IOException, InterruptedException {
        SpringApplication.run(TrendingServiceApplication.class, args);

        Server server = ServerBuilder
                .forPort(8090)
                .addService(new TrendingServiceImpl()).build();

        server.start();
        server.awaitTermination();

    }

}
