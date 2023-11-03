package com.ro.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

}

//public class OrderServiceApplication {
//
//	public static void main(String[] args) {
//		Mono<String> mono = Mono.just("apple"); // 0-1 items
//		mono.doOnNext(System.out::println)
//				.subscribe();
//
//		Flux<String> flux = Flux.just("banana", "orange"); //0,1...N items
//		flux.doOnNext(System.out::println)
//				.subscribe();
//
//	}
//
//}
