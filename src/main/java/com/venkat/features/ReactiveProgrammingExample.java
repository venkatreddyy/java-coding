package com.venkat.features;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class ReactiveProgrammingExample {

    public static void main(String[] args) {

        // Mono - Single element or empty
        Mono<String> monoExample = Mono.just("Hello, Mono!");
        monoExample
                .map(String::toUpperCase)
                .subscribe(System.out::println);

        // Mono - Empty with fallback
        Mono<String> monoFallback = Mono.<String>empty()
                .defaultIfEmpty("Fallback Mono")
                .subscribeOn(Schedulers.boundedElastic());
        monoFallback.subscribe(System.out::println);

        // Flux - Multiple elements
        List<String> fruits = Arrays.asList("Apple", "Banana", "Orange", "Mango");
        Flux<String> fluxExample = Flux.fromIterable(fruits);
        fluxExample
                .filter(fruit -> fruit.length() > 5)
                .map(String::toUpperCase)
                .subscribe(System.out::println);

        // Flux - Transforming and handling errors
        Flux<Integer> fluxWithError = Flux.range(1, 5)
                .map(i -> {
                    if (i == 4) {
                        throw new RuntimeException("Error at 4");
                    }
                    return i * 2;
                })
                .onErrorResume(e -> {
                    System.out.println("Caught error: " + e);
                    return Flux.just(-1, -2);
                });
        fluxWithError.subscribe(System.out::println);

        // Flux - Combining Flux (merge, zip, concat)
        Flux<String> flux1 = Flux.just("A", "B", "C");
        Flux<String> flux2 = Flux.just("1", "2", "3");
        Flux.zip(flux1, flux2)
                .map(tuple -> tuple.getT1() + tuple.getT2()) // Combines elements from flux1 and flux2
                .subscribe(System.out::println);

        // Flux - Simulating a delayed stream
        Flux.interval(Duration.ofSeconds(1))
                .take(5) // Limit the emission to 5 items
                .map(i -> "Tick " + i)
                .doOnNext(System.out::println)
                .blockLast(); // Block until the last emission
    }
}

