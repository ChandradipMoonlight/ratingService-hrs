package com.moonlight.ratingService.config;

import com.moonlight.commonutility.exception.GlobalExceptionHandler;
import com.moonlight.commonutility.service.ReactiveWebClientService;
import com.moonlight.commonutility.service.ReactiveWebclientServiceImpl;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class MyBeanFactory {

    @Bean
    public GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }

    @Bean
    @LoadBalanced
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }
    @Bean
    public WebClient webClient(WebClient.Builder webClientBuiler) {
        return webClientBuiler.build();
    }

    @Bean
    public ReactiveWebClientService reactiveWebClientService() {
        return new ReactiveWebclientServiceImpl();
    }
}
