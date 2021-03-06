package com.faculte.mandatPersonnel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients("com.faculte.mandatPersonnel.rest")
@EnableDiscoveryClient
public class MandatPersonnelApplication {

	public static void main(String[] args) {
		SpringApplication.run(MandatPersonnelApplication.class, args);
	}

}
