package com.ceam.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 曾帅
 * @date 2023/5/23 14:56
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MusicApp {

  public static void main(String[] args) {
    SpringApplication.run(MusicApp.class, args);
  }
}
