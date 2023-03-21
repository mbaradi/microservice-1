package com.example.microservice1.service;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.Duration;
import java.util.List;
import java.util.ArrayList;

public class Service {
    public Flux<Integer> getFluxStream(){

        return Flux.range(1,5)
                .delayElements(Duration.ofMillis(300))
                .log();

    }
    public Mono<String> showFlow(){

        List<Integer> elements = new ArrayList<>();

        Flux.just(1, 2, 3, 4)
                .log().limitRate(2)
                .subscribe(elements::add);
        return Mono.just("Successful").log();

    }
    public Flux<String> getFluxString(){

        return Flux.just("This ", "is a ", "sample ", "application").log();

    }
}
