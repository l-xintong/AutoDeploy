package com.lee.feign.controller;



import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("eurekaclient-01")
public interface DcClient {

	@GetMapping("/dc")
	String consumer();
}
