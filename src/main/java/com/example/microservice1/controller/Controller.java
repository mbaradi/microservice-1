package com.example.microservice1.controller;

import com.example.microservice1.service.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("/firstmicroservice")
public class Controller {
    private Service service = new Service();

    @GetMapping("/firstmessage")
    public String message() {
        return "Hello, welcome to the first microservice. ";
    }

    @GetMapping(value = "/fluxstream", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Integer> returnFluxStream(){

        return service.getFluxStream();

    }

    @GetMapping(value = "/showFlow")
    public Mono<String> showFlow(){

        return service.showFlow();

    }
}
