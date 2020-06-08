package com.basalt.upper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UpperApplication {

  public static void main(String[] args) {
    SpringApplication.run(UpperApplication.class, args);
  }

}
