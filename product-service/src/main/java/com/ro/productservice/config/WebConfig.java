//package com.ro.productservice.config;
//
//import org.springframework.cloud.netflix.eureka.http.EurekaClientHttpRequestFactorySupplier;
//import org.springframework.cloud.netflix.eureka.http.RestTemplateDiscoveryClientOptionalArgs;
//import org.springframework.cloud.netflix.eureka.http.RestTemplateTransportClientFactories;
//import org.springframework.context.annotation.Bean;
//
//public class WebConfig {
//
//	@Bean
//	public RestTemplateTransportClientFactories restTemplateTransportClientFactories(EurekaClientHttpRequestFactorySupplier supplier)
//	{
//	    return new RestTemplateTransportClientFactories(new RestTemplateDiscoveryClientOptionalArgs(supplier));
//	}
//}
