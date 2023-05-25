package com.ceam.auth;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
/**
 * @author 曾帅
 * @date 2023/5/23 14:59
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
public class AuthApp {

  public static void main(String[] args) {
    SpringApplication.run(AuthApp.class, args);
  }
}
