package com.ceam.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 曾帅
 * @date 2023/5/23 14:59
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApp {

  public static void main(String[] args) {
    SpringApplication.run(EurekaApp.class, args);
  }
}
